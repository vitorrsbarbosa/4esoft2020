package prova;

import prova.enumerators.Ano;
import prova.enumerators.CargoEstudantil;
import prova.enumerators.Casa;
import prova.enumerators.Posicao;
import prova.services.Hogwarts;

public class App {
    public static void main(String[] args) {

        Hogwarts grifinoria = (new Hogwarts.Builder()
                .definirAnoDoEstudante(Ano.PRIMEIRO)
                .definirCasa(Casa.GRYFFINDOR)
                .nomearCargoDoEstudante(CargoEstudantil.CAPITAO_DA_CASA).builder());

        Hogwarts sonserina = (new Hogwarts.Builder()
                .definirAnoDoEstudante(Ano.SEXTO)
                .elegerPosicaoDoJogadorDeQuadribol(Posicao.ARTILHEIRO)
                .definirCasa(Casa.SLYTHERIN)
                .nomearCargoDoEstudante(CargoEstudantil.PREFEITO).builder());

        Hogwarts corvinal = (new Hogwarts.Builder()
                .definirAnoDoEstudante(Ano.SEGUNDO)
                .elegerPosicaoDoJogadorDeQuadribol(Posicao.BATEDOR)
                .definirCasa(Casa.RAVENCLAW)
                .nomearCargoDoEstudante(CargoEstudantil.DIRETOR).builder());

        Hogwarts lufaLufa = (new Hogwarts.Builder()
                .definirAnoDoEstudante(Ano.TERCEIRO)
                .definirCasa(Casa.HUFFLEPUFF)
                .nomearCargoDoEstudante(CargoEstudantil.PREFEITO).builder());
    }
}
