package strategy.base;

public class Dinheiro implements Especie {
    double valorEntregue;

    @Override
    public double retornarTroco(double valorDoPedido) {
        return this.valorEntregue - valorDoPedido;
    }

    @Override
    public void realizarPagamento(double valorDoPedido) {
        System.out.println("pagamento realizado utilizando dinheiro em espécie");
    }
    @Override
    public boolean permitirPagamento(double valorDoPedido) {
        return this.valorEntregue > valorDoPedido;
    }
}
