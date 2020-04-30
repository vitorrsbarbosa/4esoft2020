package prova.services;

import prova.enumerators.*;
import prova.interfaces.Casa;

public class Hogwarts implements prova.interfaces.Hogwarts {
    private CargoEstudantil cargoEstudantil;
    private Posicao posicao;
    private Ano ano;
    private boolean isCalouro;

    private Hogwarts() {}
    public static class Builder {
        private CargoEstudantil cargoEstudantil;
        private Posicao posicao;
        private Ano ano;
        private Casa casa;
        private boolean isCalouro;

        public Builder nomearCardoDoEstudante() {
            this.cargoEstudantil = this.cargoEstudantil;
            return this;
        }
        public Builder elegerPosicaoDoJogadorDeQuadribol() {
            if (this.isCalouro) {
                return null;
            }
            this.posicao = this.posicao;
            return this;
        }
        public Builder definirCasa() {
            this.casa = casa;
            return this;
        }
        public Hogwarts builder() {
            Hogwarts hogwarts = new Hogwarts();
            hogwarts.cargoEstudantil = this.cargoEstudantil;
            hogwarts.posicao = this.posicao;
            return hogwarts;
        }
    }
}
