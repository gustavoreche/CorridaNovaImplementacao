package Corrida.br.com.forma.extrai.informacao.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Corrida.br.com.entrada.usuario.EntradaDoUsuario;
import Corrida.br.com.forma.extrai.informacao.log.caractere.digitado.errado.CaractereDigitadoErrado;
import Corrida.br.com.forma.extrai.informacao.log.externo.Externo;
import Corrida.br.com.forma.extrai.informacao.log.local.Local;
import Corrida.br.com.forma.extrai.informacao.log.sair.sistema.SairDoSistema;

public class FormaDeComoExtraiAInformacaoDoLogTeste {
	
	@InjectMocks
	private FormaDeComoExtraiAInformacaoDoLog formaMock = new FormaDeComoExtraiAInformacaoDoLog();
	
	@Mock
	private EntradaDoUsuario entradaDoUsuario;
	
	private static FormaDeComoExtraiAInformacaoDoLog forma;
	
	@BeforeClass
	public static void configuracaoInicial() {
		forma = new FormaDeComoExtraiAInformacaoDoLog();
	}
	
	@Before
	public void iniciaAntesDeCadaTeste() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoLocal_ok() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.LOCAL.getCodigo());
		assertEquals(new Local().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoLocal_error() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.EXTERNO.getCodigo());
		assertNotEquals(new Local().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoExterno_ok() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.EXTERNO.getCodigo());
		assertEquals(new Externo().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoExterno_error() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.LOCAL.getCodigo());
		assertNotEquals(new Externo().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoSairDoSistema_ok() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.SAIR_DO_SISTEMA.getCodigo());
		assertEquals(new SairDoSistema().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoSairDoSistema_error() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.LOCAL.getCodigo());
		assertNotEquals(new SairDoSistema().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoCaractereDigitadoErrado_ok() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.CARACTERE_DIGITADO_ERRADO.getCodigo());
		assertEquals(new CaractereDigitadoErrado().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoCaractereDigitadoErrado_error() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.SAIR_DO_SISTEMA.getCodigo());
		assertNotEquals(new CaractereDigitadoErrado().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoLocal_ok() {
		String qualquerTexto = EnumFormasDeExtracao.LOCAL.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(Local.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoLocal_error() {
		String qualquerTexto = EnumFormasDeExtracao.EXTERNO.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertNotEquals(Local.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoExterno_ok() {
		String qualquerTexto = EnumFormasDeExtracao.EXTERNO.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(Externo.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoExterno_error() {
		String qualquerTexto = EnumFormasDeExtracao.LOCAL.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertNotEquals(Externo.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoSairDoSistema_ok() {
		String qualquerTexto = EnumFormasDeExtracao.SAIR_DO_SISTEMA.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(SairDoSistema.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoSairDoSistema_error() {
		String qualquerTexto = EnumFormasDeExtracao.LOCAL.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertNotEquals(SairDoSistema.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoCaractereDigitadoErrado_ok() {
		String qualquerTexto = EnumFormasDeExtracao.CARACTERE_DIGITADO_ERRADO.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(CaractereDigitadoErrado.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoCaractereDigitadoErrado_error() {
		String qualquerTexto = EnumFormasDeExtracao.LOCAL.getCodigo();
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertNotEquals(CaractereDigitadoErrado.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoCaractereDigitadoErrado_digitandoQualquerCoisa_ok() {
		String qualquerTexto = "sadsadasd";
		Mockito.when(this.entradaDoUsuario.digitado()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(CaractereDigitadoErrado.class, verificaForma.pegaForma());
	}

}
