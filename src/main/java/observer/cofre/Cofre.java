package observer.cofre;

import java.util.ArrayList;
import java.util.List;

public class Cofre {
    boolean aberto;
    int senha;
    private List<CofreAbertoListener> cofreAbertoListeners = new ArrayList<>();
    private List<CofreFechadoListener> cofreFechadoListeners = new ArrayList<>();
    private List<CofreSenhaIncorretaListener> cofreSenhaIncorretaListeners = new ArrayList<>();

    public Cofre(int senha) {
        this.senha = senha;
        this.aberto = true;

    }
    void abrir(int senhaInformada) {
        if(senhaInformada == this.senha) {
            this.aberto = true;
            this.cofreAbertoListeners.forEach(CofreAbertoListener::cofreFoiAberto);
        }
    }

    void fechar() {
        this.aberto = false;
        this.cofreFechadoListeners.forEach(CofreFechadoListener::cofreFoiFechado);
    }
    boolean isAberto(){
        return this.aberto;
    }

    public void addListener(CofreListenerConsole listener) {
        if (listener instanceof CofreAbertoListener) {
            this.cofreAbertoListeners.add((CofreAbertoListener) listener);
        }
        if (listener instanceof CofreFechadoListener) {
            this.cofreFechadoListeners.add((CofreFechadoListener) listener);
        }
        if (listener instanceof CofreSenhaIncorretaListener) {
            this.cofreSenhaIncorretaListeners.add((CofreSenhaIncorretaListener) listener);
        }
    }
}

