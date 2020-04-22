package strategy.base;

public interface Cartao extends Pagamento {
    double adicionarImposto(double valorDaCompra);
    boolean permitirPagamento(double valorCobrado);
}
