package observer.cofre;

public class CofreListenerConsole implements CofreAbertoListener, CofreFechadoListener, CofreSenhaIncorretaListener {

    @Override
    public void cofreFoiAberto() {
        System.out.println("O cofre foi aberto");
    }

    @Override
    public void cofreFoiFechado() {
        System.out.println("O cofre foi fechado");
    }

    @Override
    public void senhaIncorretaFoiInformada(int senhaInformada) {
        System.out.println("A senha informada é Incorreta: " + senhaInformada);
    }
}
