package Corrida.br.com.forma.extrai.informacao.log.local;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;

public class LocalTeste {
	
	private static Local local;
	
	@BeforeClass
	public static void iniciaAntes() {
		local = new Local();
	}
	
	@Test
	public void verificaForma() {
		assertEquals(new Local().getClass(), local.verificaForma(EnumFormasDeExtracao.LOCAL));		
	}
	
	@Test
	public void pegaForma() {
		assertEquals(new Local().getClass(), local.pegaForma());
	}

}
