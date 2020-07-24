package br.com.forma.extrai.informacao.log;

import java.util.Arrays;

import br.com.forma.extrai.informacao.log.caractere.digitado.errado.CaractereDigitadoErrado;
import br.com.forma.extrai.informacao.log.externo.Externo;
import br.com.forma.extrai.informacao.log.local.Local;
import br.com.forma.extrai.informacao.log.sair.sistema.SairDoSistema;

public enum EnumFormasDeExtracao {
	
	LOCAL("1", Local.class),
	EXTERNO("2", Externo.class),
	SAIR_DO_SISTEMA("3", SairDoSistema.class),
	CARACTERE_DIGITADO_ERRADO("9999", CaractereDigitadoErrado.class),
	;
	
	public String codigo;
	public Class <? extends FormasDeExtracao> formaDeExtracao;

	private EnumFormasDeExtracao(String codigo, Class <? extends FormasDeExtracao> formaDeExtracao) {
		this.codigo = codigo;
		this.formaDeExtracao = formaDeExtracao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public Class<? extends FormasDeExtracao> getFormaDeExtracao() {
		return formaDeExtracao;
	}
	
	public static EnumFormasDeExtracao pegaEnumPeloCodigo(String codigo) {
		return Arrays.asList(EnumFormasDeExtracao.values())
					.stream()
					.filter(enumRetornado -> enumRetornado.getCodigo().equals(codigo))
					.findFirst()
					.orElse(CARACTERE_DIGITADO_ERRADO);
	}
	
}
