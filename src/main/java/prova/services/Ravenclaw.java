package prova.services;

import prova.interfaces.ICasa;

public class Ravenclaw implements ICasa {
    @Override
    public void estudar() {

    }

    @Override
    public void cantarHino() {
        System.out.println(
                "Ou será a velha e sábia Corvinal,\n" +
                "A casa dos que tem a mente sempre alerta,\n" +
                "Onde os homens de grande espírito e saber\n" +
                "Sempre encontrarão companheiros seus iguais."
        );
    }

    @Override
    public void nomearCargoEstudantil() {

    }
}
