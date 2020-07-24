package br.com.forma.extrai.informacao.log.sair.sistema;

import br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import br.com.forma.extrai.informacao.log.FormasDeExtracao;
import br.com.forma.extrai.informacao.log.caractere.digitado.errado.CaractereDigitadoErrado;

public class SairDoSistema implements FormasDeExtracao {
	
	private FormasDeExtracao proximaForma;
	
	public SairDoSistema() {
		this.proximaForma = new CaractereDigitadoErrado();
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaForma(EnumFormasDeExtracao respostaDoUsuario) {
		if(respostaDoUsuario == EnumFormasDeExtracao.SAIR_DO_SISTEMA) {
			System.out.println("Você escolheu encerrar o sistema. Muito obrigado!!");
			return this.pegaFormaAtual();
		}
		return this.proximaForma.pegaForma(respostaDoUsuario);
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaFormaAtual() {
		return SairDoSistema.class;
	}

}
