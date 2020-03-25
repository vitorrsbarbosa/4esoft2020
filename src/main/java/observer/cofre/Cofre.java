package observer.cofre;

import java.util.ArrayList;
import java.util.List;

public class Cofre {
    boolean aberto;
    int senha;
    private List<CofreListener> listeners = new ArrayList<>();

    public Cofre(int senha) {
        this.senha = senha;
        this.aberto = true;

    }
    void abrir(int senhaInformada) {
        if(senhaInformada == this.senha) {
            this.aberto = true;
            this.listeners.forEach(CofreListener::cofreFoiAberto);
        }
    }

    void fechar() {
        this.aberto = false;
        for(CofreListener listener : this.listeners) {
            listener.cofreFoiFechado();
        }
    }
    boolean isAberto(){
        return this.aberto;
    }

    public void addListener(CofreListenerConsole listener) {
        this.listeners.add(listener);
    }
}
