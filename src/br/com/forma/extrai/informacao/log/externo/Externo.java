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
	public Class<? extends FormasDeExtracao> verificaForma(EnumFormasDeExtracao respostaDoUsuario) {
		if(respostaDoUsuario == EnumFormasDeExtracao.EXTERNO) {
			System.out.println("EXTERNO");
			return this.pegaForma();
		}
		return this.proximaForma.verificaForma(respostaDoUsuario);
	}

	@Override
	public Class<? extends FormasDeExtracao> pegaForma() {
		return Externo.class;
	}

}
