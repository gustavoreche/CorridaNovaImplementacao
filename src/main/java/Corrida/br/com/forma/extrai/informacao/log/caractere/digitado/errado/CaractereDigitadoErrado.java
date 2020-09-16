package Corrida.br.com.forma.extrai.informacao.log.caractere.digitado.errado;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import Corrida.br.com.forma.extrai.informacao.log.FormasDeExtracao;

public class CaractereDigitadoErrado implements FormasDeExtracao {
	
	@Override
	public Class<? extends FormasDeExtracao> verificaForma(EnumFormasDeExtracao respostaDoUsuario) {
		System.out.println("Você digitou algo errado. Por favor, tente novamente \n");
		return this.pegaForma();
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaForma() {
		return CaractereDigitadoErrado.class;
	}

}
