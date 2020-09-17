package Corrida.br.com.forma.extrai.informacao.log.caractere.digitado.errado;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import Corrida.br.com.forma.extrai.informacao.log.FormasDeExtracao;
import Corrida.br.com.front.TelaInicial;

public class CaractereDigitadoErrado implements FormasDeExtracao {
	
	private TelaInicial telaInicial;
	
	public CaractereDigitadoErrado() {
		this.telaInicial = new TelaInicial();
	}
	
	@Override
	public Class<? extends FormasDeExtracao> verificaForma(EnumFormasDeExtracao respostaDoUsuario) {
		this.telaInicial.digitouErrado();
		return this.pegaForma();
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaForma() {
		return CaractereDigitadoErrado.class;
	}

}
