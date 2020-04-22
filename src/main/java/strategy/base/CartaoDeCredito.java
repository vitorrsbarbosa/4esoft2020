package strategy.base;

public class CartaoDeCredito implements Cartao {
    double impostoSobreCompra;
    double limiteDisponivel;
    @Override
    public double adicionarImposto(double valorDaCompra) {
        return this.impostoSobreCompra = valorDaCompra + valorDaCompra* this.impostoSobreCompra;
    }

    @Override
    public boolean permitirPagamento(double valorDoPedido) {
        return this.limiteDisponivel > valorDoPedido;
    }

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("pagamento realizado utilizando cartão de crédito");
    }
}
