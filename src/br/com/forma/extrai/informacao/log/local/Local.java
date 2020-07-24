package br.com.forma.extrai.informacao.log.local;

import br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import br.com.forma.extrai.informacao.log.FormasDeExtracao;
import br.com.forma.extrai.informacao.log.externo.Externo;

public class Local implements FormasDeExtracao {
	
	private FormasDeExtracao proximaForma;
	
	public Local() {
		this.proximaForma = new Externo();
	}

	@Override
	public Class<? extends FormasDeExtracao> verificaForma(EnumFormasDeExtracao respostaDoUsuario) {
		if(respostaDoUsuario == EnumFormasDeExtracao.LOCAL) {
			System.out.println("LOCAL");
			return this.pegaForma();
		}
		return this.proximaForma.verificaForma(respostaDoUsuario);
	}
	
	@Override
	public Class<? extends FormasDeExtracao> pegaForma() {
		return Local.class;
	}

}
