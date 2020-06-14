package aula20200512.forum;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import aula20200512.exception.LimiteDeCreditosExcedidoException;
import aula20200512.gerenciadorDeCompras.GerenciamentoDeCompras;

public class TestesDoForum {
//    @Test
//    void testarCompraSemRenovarCrédito() {
//      GerenciamentoDeCompras compraSemLimite = new GerenciamentoDeCompras("000000000");
//      assertThrows(LimiteDeCreditosExcedidoException.class, ()-> {
//          compraSemLimite.efetuarCompra("000000000", 15.00);
//      });
//    }
//    @Test
//    void testarCompraRenovandoCrédito() {
//        GerenciamentoDeCompras compraComLimite = new GerenciamentoDeCompras("000000000");
//        compraComLimite.renovarLimiteDeCredito("000000000");
//        Exception realizarCompraAssert = assertThrows(LimiteDeCreditosExcedidoException.class, () -> {
//            compraComLimite.efetuarCompra("000000000", 15.00);
//        });
// }
//
// @Test
// void testarRenovarLimite() {
//      GerenciamentoDeCompras renovarLimite = new GerenciamentoDeCompras("000000000");
//      renovarLimite.renovarLimiteDeCredito("000000000");
//      assertTrue(renovarLimite.renovarLimiteDeCredito("000000000"));
//  }
//
// @Test
// void testarRetornoDeSaldoSemRenovarLimite() {
//      GerenciamentoDeCompras retornaSaldo = new GerenciamentoDeCompras("000000000");
//      assertThat(retornaSaldo.getSaldoLimiteDeCredito("000000000")).isEqual(0);
//  }
//
//@Test
//void testarRetornoDeSaldoRenovandoLimite() {
//      GerenciamentoDeCompras retornaSaldo = new GerenciamentoDeCompras("000000000");
//      retornaSaldo.renovarLimiteDeCredito("000000000");
//      assertThat(retornaSaldo.getSaldoLimiteDeCredito("000000000")).isEqual(25000.00);
//  }
}
