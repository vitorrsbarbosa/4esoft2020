package prova.services;

import prova.interfaces.ICasa;

public class Gryffindor implements ICasa {
    @Override
    public void estudar() {

    }

    @Override
    public void cantarHino() {
        System.out.println(
                "Quem sabe sua morada é a Grifinória;\n" +
                "Casa onde habitam os corações indômitos;\n" +
                "Ousadia e sangue-frio e nobreza Destacam os alunos da Grifinória dos demais;"
        );
    }

    @Override
    public void nomearCargoEstudantil() {

    }
}
