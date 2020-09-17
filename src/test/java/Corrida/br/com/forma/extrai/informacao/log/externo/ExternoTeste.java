package Corrida.br.com.forma.extrai.informacao.log.externo;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;

public class ExternoTeste {
	
	private static Externo externo;
	
	@BeforeClass
	public static void iniciaAntes() {
		externo = new Externo();
	}
	
	@Test
	public void verificaForma() {
		assertEquals(new Externo().getClass(), externo.verificaForma(EnumFormasDeExtracao.EXTERNO));		
	}
	
	@Test
	public void pegaForma() {
		assertEquals(new Externo().getClass(), externo.pegaForma());
	}

}
