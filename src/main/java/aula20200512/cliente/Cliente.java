package aula20200512.cliente;

public class Cliente {
    String cpfCliente;
    double limiteDeCompra = 25_000d;

    public Cliente(String cpfCliente, double limiteDeCompra) {
        this.cpfCliente = cpfCliente;
        this.limiteDeCompra = limiteDeCompra;
    }
}