package strategy.base;

public interface Pagamento {
    void realizarPagamento(double valorDoPedido);
    boolean permitirPagamento(double valorDoPedido);
}
