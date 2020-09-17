package Corrida.br.com.forma.extrai.informacao.log.sair.sistema;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import Corrida.br.com.forma.extrai.informacao.log.FormasDeExtracao;
import Corrida.br.com.forma.extrai.informacao.log.caractere.digitado.errado.CaractereDigitadoErrado;
import Corrida.br.com.front.TelaInicial;

public class SairDoSistema implements FormasDeExtracao {
	
	private FormasDeExtracao proximaForma;
	private TelaInicial telaInicial;
	
	public SairDoSistema() {
		this.proximaForma = new CaractereDigitadoErrado();
		this.telaInicial = new TelaInicial();
	}

	@Override
	public Class<? extends FormasDeExtracao> verificaForma(EnumFormasDeExtracao respostaDoUsuario) {
		if(respostaDoUsuario == EnumFormasDeExtracao.SAIR_DO_SISTEMA) {
			this.telaInicial.sairDoSistema();
			return this.pegaForma();
		}
		return this.proximaForma.verificaForma(respostaDoUsuario);
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaForma() {
		return SairDoSistema.class;
	}

}
