package br.com.forma.extrai.informacao.log.externo;

import br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import br.com.forma.extrai.informacao.log.FormasDeExtracao;
import br.com.forma.extrai.informacao.log.sair.sistema.SairDoSistema;

public class Externo implements FormasDeExtracao {
	
	private FormasDeExtracao proximaForma;
	
	public Externo() {
		this.proximaForma = new SairDoSistema();
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaForma(EnumFormasDeExtracao respostaDoUsuario) {
		if(respostaDoUsuario == EnumFormasDeExtracao.EXTERNO) {
			System.out.println("EXTERNO");
			return this.pegaFormaAtual();
		}
		return this.proximaForma.pegaForma(respostaDoUsuario);
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaFormaAtual() {
		return Externo.class;
	}

}
