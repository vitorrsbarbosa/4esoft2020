package bimestre02.prova.produto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProdutoTest {

    @Test
    void exercicio01_atualizarOObjetoComMetodoComParametro() {
//        Given
        Produto leiteDeCaixa = new Produto("Lider");
        Produto cerealMatinal = new Produto("Kelloggs");
//        When
        leiteDeCaixa.atualizarMarca("Parmalat");
        cerealMatinal.atualizarMarca("Moça");
//        Then
        assertThat(leiteDeCaixa.getMarca()).isNotEqualTo("Lider");
        assertThat(leiteDeCaixa).hasFieldOrPropertyWithValue("marca", "Parmalat");
        assertThat(cerealMatinal.getMarca()).isNotEqualTo("Kelloggs");
        assertThat(cerealMatinal).hasFieldOrPropertyWithValue("marca", "Moça");

    }
    @Test
    void exercicio02_atualizarOObjetoComMetodoSemParamentros() {
//        Given
        Produto leiteDeCaixa = new Produto("Lider");
        Produto macarraoInstantaneo = new Produto("Nissin");
//        When
        leiteDeCaixa.incluirMaisUmNaLista();
        for (int i = 0; i < 5; i++) {
            macarraoInstantaneo.incluirMaisUmNaLista();
        }
//        Then
        assertThat(leiteDeCaixa.getQuantidade()).isEqualTo(2);
        assertThat(macarraoInstantaneo.getQuantidade()).isEqualTo(6);
    }
    @Test
    void exercicio03_lancarExcessao() {
//        Given
        Produto pacoteDeCerveja = new Produto("Budweiser", 12);
//        When
        for (int i = 0; i < 12; i++) {
            pacoteDeCerveja.removerItem();
        }
//        Then
        assertThat(pacoteDeCerveja.getQuantidade()).isEqualTo(0);
        RuntimeException exception = assertThrows(RuntimeException.class,
                pacoteDeCerveja::removerItem); {
            assertThat(exception.getMessage()).isEqualTo("não é possível remover item com quantidade = 0");
        }
    }
    @Test
    void exercicio04_obterValorENaoAlteralo() {
//        Given
        Produto lataDeCerveja = new Produto("Budweiser");
        Produto sorvete = new Produto("Kibon");
//        When/Then
        assertThat(lataDeCerveja.getMarca()).isEqualTo("Budweiser");
        assertThat(sorvete.getMarca()).isEqualTo("Kibon");
    }
    @Test
    void exercicio05_retornarOMesmoValorPassadoNoParametro(){
//        Given
        Venda venda = new Venda();
        Produto lataDeCerveja = new Produto("Budweiser", 12, 3.5);
        Produto sorvete = new Produto("Kibon", 1, 12.5);
        List<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(lataDeCerveja);
        listaDeProdutos.add(sorvete);
        double valorTotalComDesconto = venda.retornarValorComDesconto(listaDeProdutos, 0.25);
//        When/Then
        assertThat(valorTotalComDesconto).isEqualTo(12d);
    }
}