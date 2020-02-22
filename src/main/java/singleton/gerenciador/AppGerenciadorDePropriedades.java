package singleton.gerenciador;

import static java.lang.System.out;

public class AppGerenciadorDePropriedades {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            out.println(GerenciadorDePropriedades.getInstance());
        }
        GerenciadorDePropriedades gerenciadorDePropriedades = GerenciadorDePropriedades.getInstance();
        out.println(gerenciadorDePropriedades.getValorDaPropriedade("icms-estadual-base"));
        out.println(gerenciadorDePropriedades.getValorDaPropriedade("considerar-saldo-em-credito-financeiro"));
    }
}
