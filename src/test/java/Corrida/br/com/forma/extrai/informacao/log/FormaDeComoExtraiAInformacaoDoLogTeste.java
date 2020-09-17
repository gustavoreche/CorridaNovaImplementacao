package Corrida.br.com.forma.extrai.informacao.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	public void verificaResposta_formaDeExtracaoLocal() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.LOCAL.getCodigo());
		assertEquals(new Local().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoExterno() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.EXTERNO.getCodigo());
		assertEquals(new Externo().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoSairDoSistema() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.SAIR_DO_SISTEMA.getCodigo());
		assertEquals(new SairDoSistema().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void verificaResposta_formaDeExtracaoCaractereDigitadoErrado() {
		Class<? extends FormasDeExtracao> verificaResposta = forma
				.verificaResposta(EnumFormasDeExtracao.CARACTERE_DIGITADO_ERRADO.getCodigo());
		assertEquals(new CaractereDigitadoErrado().getClass().getName(), verificaResposta.getName());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoLocal() {
		String qualquerTexto = EnumFormasDeExtracao.LOCAL.getCodigo();
		Mockito.when(this.entradaDoUsuario.pega()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(Local.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoExterno() {
		String qualquerTexto = EnumFormasDeExtracao.EXTERNO.getCodigo();
		Mockito.when(this.entradaDoUsuario.pega()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(Externo.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoSairDoSistema() {
		String qualquerTexto = EnumFormasDeExtracao.SAIR_DO_SISTEMA.getCodigo();
		Mockito.when(this.entradaDoUsuario.pega()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(SairDoSistema.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoCaractereDigitadoErrado() {
		String qualquerTexto = EnumFormasDeExtracao.CARACTERE_DIGITADO_ERRADO.getCodigo();
		Mockito.when(this.entradaDoUsuario.pega()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(CaractereDigitadoErrado.class, verificaForma.pegaForma());
	}
	
	@Test
	public void pegaForma_retornaFormaDeExtracaoCaractereDigitadoErrado_digitandoQualquerCoisa() {
		String qualquerTexto = "sadsadasd";
		Mockito.when(this.entradaDoUsuario.pega()).thenReturn(qualquerTexto);
		FormasDeExtracao verificaForma = formaMock.pegaForma();
		assertEquals(CaractereDigitadoErrado.class, verificaForma.pegaForma());
	}
	
	@Test
	public void atingiuLimite_naoAtingiuLimite() {
		assertFalse(forma.atingiuLimite(2));
	}
	
	@Test
	public void atingiuLimite_noLimite() {
		assertTrue(forma.atingiuLimite(FormaDeComoExtraiAInformacaoDoLog.LIMITE_MAXIMO_DE_REPETICAO));
	}
	
	@Test
	public void atingiuLimite_passouDoLimite() {
		assertTrue(forma.atingiuLimite(4));
	}
	
}
