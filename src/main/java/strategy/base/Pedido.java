package strategy.base;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    double valorTotal;
    List<Pagamento> meiosDePagamento = new ArrayList<>();

    void adicionarMeioDePagamento(Pagamento pagamento) {
        this.meiosDePagamento.add(pagamento);
    }

}
