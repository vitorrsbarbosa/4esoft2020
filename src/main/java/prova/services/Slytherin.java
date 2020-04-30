package prova.services;

import prova.interfaces.ICasa;

public class Slytherin implements ICasa {
    @Override
    public void estudar() {

    }

    @Override
    public void cantarHino() {
        System.out.println(
                "Quem sabe a Sonserina será a sua casa;\n" +
                "E ali fará seus verdadeiros amigos;\n" +
                "Homens de astúcia que usam quaisquer meios " +
                "para atingir os fins que antes colimaram;"
        );
    }

    @Override
    public void nomearCargoEstudantil() {

    }
}
