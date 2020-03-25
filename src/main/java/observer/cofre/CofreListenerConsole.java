package observer.cofre;

import java.util.Date;

public class CofreListenerConsole extends CofreListener {
    @Override
    void cofreFoiAberto() {
        System.out.println("O cofre foi aberto: " + new Date().toLocaleString());
    }
    @Override
    void cofreFoiFechado() {
        System.out.println("O cofer foi fechado: " + new Date().toLocaleString());
    }
}
