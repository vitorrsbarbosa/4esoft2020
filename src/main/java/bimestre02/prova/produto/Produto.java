package bimestre02.prova.produto;

public class Produto {
    private String marca;
    private int quantidade = 1;
    private Double valor = 1d;

    public Produto() {
    }
    public Produto(String marca) {
        this.marca = marca;
    }

    public Produto(String marca, int quantidade) {
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public Produto(String marca, int quantidade, double valor) {
        this.marca = marca;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String atualizarMarca(String novaMarca) {
        return this.marca = novaMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void incluirMaisUmNaLista() {
        this.quantidade += 1;
    }

    public int removerItem() {
        if (this.quantidade != 0) {
            return this.quantidade -= 1;
        }
        throw new RuntimeException("não é possível remover item com quantidade = 0");
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}