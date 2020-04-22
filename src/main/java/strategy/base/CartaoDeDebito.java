package strategy.base;

public class CartaoDeDebito implements Cartao {
    double limiteEmConta;
    double impostoSobreCompra;

    @Override
    public double adicionarImposto(double valorDaCompra) {
        return this.impostoSobreCompra = valorDaCompra + valorDaCompra* this.impostoSobreCompra;
    }

    @Override
    public boolean permitirPagamento(double valorCobrado) {
        if (this.limiteEmConta > valorCobrado){
            return true;
        } else {
            System.out.println("compra negada! :x");
            return false;
        }

    }

    @Override
    public void realizarPagamento(double valor) {
        System.out.println("pagamento realizado utilizando cartão de débito");

    }
}
