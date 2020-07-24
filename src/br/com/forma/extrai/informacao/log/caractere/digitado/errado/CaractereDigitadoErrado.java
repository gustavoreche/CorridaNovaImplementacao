package br.com.forma.extrai.informacao.log.caractere.digitado.errado;

import br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import br.com.forma.extrai.informacao.log.FormasDeExtracao;

public class CaractereDigitadoErrado implements FormasDeExtracao {
	
	@Override
	public Class<? extends FormasDeExtracao> pegaForma(EnumFormasDeExtracao respostaDoUsuario) {
		System.out.println("Você digitou algo errado. Por favor, tente novamente \n");
		return this.pegaFormaAtual();
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaFormaAtual() {
		return CaractereDigitadoErrado.class;
	}

}
