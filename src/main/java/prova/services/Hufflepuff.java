package prova.services;

import prova.interfaces.ICasa;

public class Hufflepuff implements ICasa {
    @Override
    public void estudar() {

    }

    @Override
    public void cantarHino() {
        System.out.println(
                "Quem sabe é na Lufa-Lufa que você vai morar;\n" +
                "Onde seus moradores são justos e leais,\n" +
                "Pacientes, sinceros, sem medo da dor;"
        );
    }

    @Override
    public void nomearCargoEstudantil() {

    }
}
