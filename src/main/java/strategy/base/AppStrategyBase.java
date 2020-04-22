package strategy.base;

public class AppStrategyBase {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.valorTotal = 500;

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
        cartaoDeCredito.impostoSobreCompra = 0.01;
        cartaoDeCredito.limiteDisponivel = 1000;

        CartaoDeDebito cartaoDeDebitoComLimite = new CartaoDeDebito();
        cartaoDeDebitoComLimite.impostoSobreCompra = 0;
        cartaoDeDebitoComLimite.limiteEmConta = 2500;

        CartaoDeDebito cartaoDeDebitoSemLimite = new CartaoDeDebito();
        cartaoDeDebitoSemLimite.impostoSobreCompra = 0;
        cartaoDeDebitoSemLimite.limiteEmConta = 100;

        Dinheiro dinheiro = new Dinheiro();
        dinheiro.valorEntregue = 150;

        pedido.adicionarMeioDePagamento(cartaoDeCredito);
        if (cartaoDeCredito.permitirPagamento(pedido.valorTotal)) {
            cartaoDeCredito.adicionarImposto(pedido.valorTotal);
            cartaoDeCredito.realizarPagamento(pedido.valorTotal);
        }

        pedido.adicionarMeioDePagamento(cartaoDeDebitoComLimite);
        if(cartaoDeDebitoComLimite.permitirPagamento(pedido.valorTotal)) {
            cartaoDeDebitoComLimite.adicionarImposto(pedido.valorTotal);
            cartaoDeDebitoComLimite.realizarPagamento(pedido.valorTotal);
        }

        pedido.adicionarMeioDePagamento(cartaoDeDebitoSemLimite);
        if(cartaoDeDebitoSemLimite.permitirPagamento(pedido.valorTotal)){
            cartaoDeDebitoSemLimite.adicionarImposto(pedido.valorTotal);
            cartaoDeDebitoSemLimite.realizarPagamento(pedido.valorTotal);
        }
    }
}
