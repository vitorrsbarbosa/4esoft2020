package aula20200519.parcelamento;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestesComParcelamento {
	  //Parcelamento.parcelar(
	  //     valorParaParcelar : BigDecimal, 
	  //     quantidadeDeParcelas : int, 
	  //     diferençaNaPrimeiraParcela : boolean, 
	  //     valorMínimoDaParcela : BigDecimal) : List<Parcela>
/*	
	100.00
	3
	true
	10.00
	
	100.00 / 3 = 33.333333333333
	33.33
	33.33 * 3 = 99.99
	100.00 = 99.99 = 0.01
	
	Diferença na primeira parcela
	33.33 + 0.01 = 33.34
	 
	Parcelas resultantes 
	33.34
	33.33
	33.33
*/	
	@Test
	void testar_parcelamento_diferenca_na_primeira_parcela() {
		BigDecimal valorParaParcelar = new BigDecimal("100.00");
		Integer numeroDeParcelas = 3;
		Boolean diferencaNaPrimeiraParcela = true;
		BigDecimal valorMinimoDaParcela = new BigDecimal("10.00");
		
		List<Parcela> parcelas = Parcelamento.parcelar(
				valorParaParcelar, numeroDeParcelas, diferencaNaPrimeiraParcela, valorMinimoDaParcela);
		
		assertEquals(3, parcelas.size());
		
		assertEquals(new BigDecimal("33.34"), parcelas.get(0).getValor());
		assertEquals(new BigDecimal("33.33"), parcelas.get(1).getValor());
		assertEquals(new BigDecimal("33.33"), parcelas.get(2).getValor());
	}

	@Test
	void testar_parcelamento_sem_diferenca_na_primeira_parcela() {
		BigDecimal valorParaParcelar = new BigDecimal("100.00");
		Integer numeroDeParcelas = 3;
		Boolean diferencaNaPrimeiraParcela = true;
		BigDecimal valorMinimoDaParcela = new BigDecimal("35.00");
		
		List<Parcela> parcelas = Parcelamento.parcelar(
				valorParaParcelar, numeroDeParcelas, diferencaNaPrimeiraParcela, valorMinimoDaParcela);
		
		assertEquals(3, parcelas.size());
		
		assertEquals(new BigDecimal("33.34"), parcelas.get(0).getValor());
		assertEquals(new BigDecimal("33.33"), parcelas.get(1).getValor());
		assertEquals(new BigDecimal("33.33"), parcelas.get(2).getValor());
	}

	@Test
	void testar_com_quatro_parcelas_de_valores_iguais() {
		//Given
		BigDecimal valorTotalAParcelar = new BigDecimal("30.00");
		Integer numeroDeParcelas = 3;
		Boolean diferencaNaPrimeiraParcela = true;
		BigDecimal valorMinimo = new BigDecimal("1.00");
		BigDecimal valorDaParcela = new BigDecimal("7.50");
		//When
		List<Parcela> parcelas = Parcelamento.parcelar(valorTotalAParcelar, numeroDeParcelas, diferencaNaPrimeiraParcela, valorMinimo);
		//Then
		assertEquals(parcelas.size(), numeroDeParcelas, "quantidade de parcelas");

		assertEquals(parcelas.get(0).getValor(), valorDaParcela, "valor da primeira parcela");
		assertEquals(parcelas.get(1).getValor(), valorDaParcela, "valor da segunda parcela");
		assertEquals(parcelas.get(2).getValor(), valorDaParcela, "valor da terceira parcela");
		assertEquals(parcelas.get(3).getValor(), valorDaParcela, "valor da quarta parcela");
	}
	@Test
	void testar_com_quatro_parcelas_de_valores_diferentes() {
		//Given
		BigDecimal valorTotalAParcelar = new BigDecimal("12.99");
		Integer numeroDeParcelas = 3;
		Boolean diferencaNaPrimeiraParcela = true;
		BigDecimal valorMinimo = new BigDecimal("5.00");
		BigDecimal valorDaPrimeiraParcela = new BigDecimal("33.34");
		//When
		List<Parcela> parcelas = Parcelamento.parcelar(valorTotalAParcelar, numeroDeParcelas, diferencaNaPrimeiraParcela, valorMinimo);
		//Then
		assertEquals(parcelas.size(), numeroDeParcelas, "quantidade de parcelas");

		assertEquals(valorDaPrimeiraParcela, parcelas.get(0).getValor(), "valor da primeira parcela");
	}
}
