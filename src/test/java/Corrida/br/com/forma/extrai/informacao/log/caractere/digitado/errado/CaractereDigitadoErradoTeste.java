package Corrida.br.com.forma.extrai.informacao.log.caractere.digitado.errado;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;

public class CaractereDigitadoErradoTeste {
	
	private static CaractereDigitadoErrado caractereDigitadoErrado;
	
	@BeforeClass
	public static void iniciaAntes() {
		caractereDigitadoErrado = new CaractereDigitadoErrado();
	}
	
	@Test
	public void verificaForma() {
		assertEquals(new CaractereDigitadoErrado().getClass(), caractereDigitadoErrado.verificaForma(EnumFormasDeExtracao.CARACTERE_DIGITADO_ERRADO));		
	}
	
	@Test
	public void pegaForma() {
		assertEquals(new CaractereDigitadoErrado().getClass(), caractereDigitadoErrado.pegaForma());
	}

}
