package Corrida.br.com.entrada.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Corrida.br.com.entrada.usuario.EntradaDoUsuario;

public class EntradaDoUsuarioTeste {
	
	@Mock
	EntradaDoUsuario entrada;
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void digitado_digitandoQualquerTexto_ok() {
		String qualquerTexto = "qualquer texto";
		Mockito.when(this.entrada.pega()).thenReturn(qualquerTexto);
		assertEquals(qualquerTexto, this.entrada.pega());	
	}
	
	@Test
	public void digitado_digitandoQualquerTexto_error() {
		String qualquerTexto = "qualquer texto";
		Mockito.when(this.entrada.pega()).thenReturn(qualquerTexto);
		assertFalse(this.entrada.pega().isEmpty());	
	}
	
	@Test
	public void digitado_digitandoVazio_ok() {
		String qualquerTexto = "";
		Mockito.when(this.entrada.pega()).thenReturn(qualquerTexto);
		assertTrue(this.entrada.pega().isEmpty());	
	}
	
	@Test
	public void digitado_digitandoVazio_error() {
		String qualquerTexto = "";
		Mockito.when(this.entrada.pega()).thenReturn(qualquerTexto);
		assertNotEquals("oi", this.entrada.pega());
	}
	
	@Test
	public void digitado_digitandoNullo_ok() {
		String qualquerTexto = null;
		Mockito.when(this.entrada.pega()).thenReturn(qualquerTexto);
		assertNull(this.entrada.pega());
	}
	
	@Test
	public void digitado_digitandoNullo_error() {
		String qualquerTexto = null;
		Mockito.when(this.entrada.pega()).thenReturn(qualquerTexto);
		assertNotEquals("", this.entrada.pega());
	}

}
