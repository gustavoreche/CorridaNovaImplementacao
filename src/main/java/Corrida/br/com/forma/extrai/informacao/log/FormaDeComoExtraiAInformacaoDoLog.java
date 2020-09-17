package Corrida.br.com.forma.extrai.informacao.log;

import java.lang.reflect.Constructor;

import Corrida.br.com.entrada.usuario.EntradaDoUsuario;
import Corrida.br.com.exception.SemFormaDeExtracaoException;
import Corrida.br.com.forma.extrai.informacao.log.caractere.digitado.errado.CaractereDigitadoErrado;
import Corrida.br.com.forma.extrai.informacao.log.local.Local;
import Corrida.br.com.front.TelaInicial;

public class FormaDeComoExtraiAInformacaoDoLog {
	
	private FormasDeExtracao formaDeExtracaoDoLog;
	private EntradaDoUsuario entradaDoUsuario;
	private TelaInicial telaInicial;
	
	private int repeticoes;
	private Class<? extends FormasDeExtracao> formaDeExtracao;
	
	protected static final int LIMITE_MAXIMO_DE_REPETICAO = 3;
	
	public FormaDeComoExtraiAInformacaoDoLog() {
		this.formaDeExtracaoDoLog = new Local();
		this.entradaDoUsuario = new EntradaDoUsuario();
		this.telaInicial = new TelaInicial();
		this.repeticoes = 0;
		this.formaDeExtracao = null;
	}
	
	public FormasDeExtracao pegaForma() {
		this.repeticoes = 0;
		do {
			this.formaDeExtracao = pegaRespostaDoUsuario();
			this.repeticoes++;
		} while (continuaPerguntando());
		verificaSeAtingiuLimiteMaximoDeTentativa();
		armazenaFormaDeExtracaoDoLog();
		return this.formaDeExtracaoDoLog;			
	}

	private Class<? extends FormasDeExtracao> pegaRespostaDoUsuario() {
		this.telaInicial.opcoesDeFormaDeExtracaoDoLog();
		return verificaResposta(this.entradaDoUsuario.pega());
	}
	
	protected Class<? extends FormasDeExtracao> verificaResposta(String respostaDoUsuario) {
		EnumFormasDeExtracao enumFormaDeExtracao = EnumFormasDeExtracao
				.pegaEnumPeloCodigo(respostaDoUsuario);
		if(enumFormaDeExtracao == null)
			throw new SemFormaDeExtracaoException();
		return this.formaDeExtracaoDoLog.verificaForma(enumFormaDeExtracao);
	}
	
	private boolean continuaPerguntando() {
		return this.formaDeExtracao != null && 
				this.formaDeExtracao.getName().equals(new CaractereDigitadoErrado().getClass().getName()) && 
				!atingiuLimite(this.repeticoes);
	}

	protected boolean atingiuLimite(int repeticoes) {
		return repeticoes >= LIMITE_MAXIMO_DE_REPETICAO;
	}
	
	private void verificaSeAtingiuLimiteMaximoDeTentativa() {
		if(atingiuLimite(this.repeticoes))
			this.telaInicial.numeroDeTentativaExcedida();
	}

	private void armazenaFormaDeExtracaoDoLog() {
		try {
			Constructor<? extends FormasDeExtracao> construtor = this.formaDeExtracao.getConstructor();
			this.formaDeExtracaoDoLog = construtor.newInstance();
		} catch (Exception e) {
			System.err.println("FormaDeComoExtraiAInformacaoDoLog - trataFormaDeExtracao - Erro no tratamento da forma de extracao do log."
					+ "Exception: " + e);
			this.formaDeExtracaoDoLog = null;
		}
	}
	
}
