package Corrida.br.com.forma.extrai.informacao.log.sair.sistema;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;

public class SairDoSistemaTeste {
	
	private static SairDoSistema sairDoSistema;
	
	@BeforeClass
	public static void iniciaAntes() {
		sairDoSistema = new SairDoSistema();
	}
	
	@Test
	public void verificaForma() {
		assertEquals(new SairDoSistema().getClass(), sairDoSistema.verificaForma(EnumFormasDeExtracao.SAIR_DO_SISTEMA));		
	}
	
	@Test
	public void pegaForma() {
		assertEquals(new SairDoSistema().getClass(), sairDoSistema.pegaForma());
	}

}
