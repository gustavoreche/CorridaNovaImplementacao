package br.com.forma.extrai.informacao.log;

public interface FormasDeExtracao {
	
	Class<? extends FormasDeExtracao> pegaForma(EnumFormasDeExtracao respostaDoUsuario);
	
	Class<? extends FormasDeExtracao> pegaFormaAtual();
	
}
