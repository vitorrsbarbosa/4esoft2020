package prova.services;

import prova.enumerators.*;
import prova.enumerators.Casa;
import prova.interfaces.*;

public class Hogwarts implements IHogwarts {
    private CargoEstudantil cargoEstudantil;
    private Posicao posicao;
    private Ano ano;
    private Hogwarts() {}
    @Override
    public void estudar() { }
    @Override
    public void cantarHino() { }
    @Override
    public void nomearCargoEstudantil() { }
    public static class Builder {
        private CargoEstudantil cargoEstudantil;
        private Posicao posicao;
        private Ano ano;
        private Casa casa;
        public Builder nomearCargoDoEstudante(CargoEstudantil cargoEstudantil) {
            this.cargoEstudantil = cargoEstudantil;
            return this;
        }
        public Builder elegerPosicaoDoJogadorDeQuadribol(Posicao posicao) {
            this.posicao = posicao;
            return this;
        }
        public Builder definirAnoDoEstudante(Ano ano) {
            this.ano = ano;
            return this;
        }
        public Builder definirCasa(Casa casa) {
            this.casa = casa;
            return this;
        }
        public Hogwarts builder() {
            Hogwarts escola = new Hogwarts();
            escola.ano = this.ano;
            escola.cargoEstudantil = this.cargoEstudantil;
            escola.posicao = this.posicao;
            return escola;
        }
    }
}
