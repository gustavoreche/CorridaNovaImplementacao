package Corrida.br.com.forma.extrai.informacao.log;

import java.lang.reflect.Constructor;

import Corrida.br.com.entrada.usuario.EntradaDoUsuario;
import Corrida.br.com.forma.extrai.informacao.log.caractere.digitado.errado.CaractereDigitadoErrado;
import Corrida.br.com.forma.extrai.informacao.log.local.Local;
import Corrida.br.com.front.TelaInicial;

public class FormaDeComoExtraiAInformacaoDoLog {
	
	private FormasDeExtracao formaDeExtracaoDoLog;
	private EntradaDoUsuario entradaDoUsuario;
	private TelaInicial telaInicial;
	
	private static final int LIMITE_MAXIMO_DE_REPETICAO = 3;
	
	public FormaDeComoExtraiAInformacaoDoLog() {
		this.formaDeExtracaoDoLog = new Local();
		this.entradaDoUsuario = new EntradaDoUsuario();
		this.telaInicial = new TelaInicial();
	}
	
	public FormasDeExtracao pegaForma() {
		String respostaDoUsuario = "";
		Class<? extends FormasDeExtracao> formaDeExtracao = null;
		int repeticoes = 0;
		do {
			this.telaInicial.exibeOpcoesDeFormaDeExtracaoDoLog();
			respostaDoUsuario = this.entradaDoUsuario.digitado();
			formaDeExtracao = this.verificaResposta(respostaDoUsuario);
			repeticoes++;
		} while (formaDeExtracao.getName().equals(new CaractereDigitadoErrado().getClass().getName()) && repeticoes < LIMITE_MAXIMO_DE_REPETICAO);
		if(repeticoes == LIMITE_MAXIMO_DE_REPETICAO) {
			System.out.println("Número de tentativas excedidas... O sistema será encerrado!");
		}
		this.formaDeExtracaoDoLog = trataFormaDeExtracao(formaDeExtracao);
		return this.formaDeExtracaoDoLog;			
	}

	protected FormasDeExtracao trataFormaDeExtracao(Class<? extends FormasDeExtracao> formaDeExtracao) {
		try {
			Constructor<? extends FormasDeExtracao> construtor = formaDeExtracao.getConstructor();
			return construtor.newInstance();
		} catch (Exception e) {
			System.err.println("FormaDeComoExtraiAInformacaoDoLog - trataFormaDeExtracao - Erro no tratamento da forma de extracao do log."
					+ "Exception: " + e);
			return null;
		}
	}

	protected Class<? extends FormasDeExtracao> verificaResposta(String respostaDoUsuario) {
		EnumFormasDeExtracao enumFormaDeExtracao = EnumFormasDeExtracao
				.pegaEnumPeloCodigo(respostaDoUsuario);
		return this.formaDeExtracaoDoLog.verificaForma(enumFormaDeExtracao);
	}

}
