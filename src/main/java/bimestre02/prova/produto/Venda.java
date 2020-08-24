package bimestre02.prova.produto;

import java.util.List;

public class Venda {
    Double retornarValorComDesconto(List<Produto> produtos, double desconto) {
        if (desconto > 1 || desconto < 0) {
            throw new RuntimeException("o desconto deve estar entre 0 e 1");
        }
        double total = produtos.stream().mapToDouble(Produto::getValor).sum();
        return total - total*desconto;
    }
}
