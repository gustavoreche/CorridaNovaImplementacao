package br.com.forma.extrai.informacao.log;

public interface FormasDeExtracao {
	
	Class<? extends FormasDeExtracao> verificaForma(EnumFormasDeExtracao respostaDoUsuario);
	
	Class<? extends FormasDeExtracao> pegaForma();
	
}
