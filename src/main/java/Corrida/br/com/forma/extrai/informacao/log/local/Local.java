package Corrida.br.com.forma.extrai.informacao.log.local;

import Corrida.br.com.forma.extrai.informacao.log.EnumFormasDeExtracao;
import Corrida.br.com.forma.extrai.informacao.log.FormasDeExtracao;
import Corrida.br.com.forma.extrai.informacao.log.externo.Externo;

public class Local implements FormasDeExtracao {
	
	private FormasDeExtracao proximaForma;
	
	public Local() {
		this.proximaForma = new Externo();
	}

	@Override
	public Class<? extends FormasDeExtracao> verificaForma(EnumFormasDeExtracao respostaDoUsuario) {
		if(respostaDoUsuario == EnumFormasDeExtracao.LOCAL)
			return this.pegaForma();
		return this.proximaForma.verificaForma(respostaDoUsuario);
	}
	
	@Override
	public Class<? extends FormasDeExtracao> pegaForma() {
		return Local.class;
	}

}
