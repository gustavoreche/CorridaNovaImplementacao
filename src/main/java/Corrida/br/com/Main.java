package Corrida.br.com;

import br.com.forma.extrai.informacao.log.FormaDeComoExtraiAInformacaoDoLog;
import br.com.forma.extrai.informacao.log.FormasDeExtracao;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Bem vindo leitor de log!");
		FormasDeExtracao formaDeExtracao = new FormaDeComoExtraiAInformacaoDoLog().pegaForma();
	}
	
}
