package Corrida.br.com;

import Corrida.br.com.forma.extrai.informacao.log.FormaDeComoExtraiAInformacaoDoLog;
import Corrida.br.com.forma.extrai.informacao.log.FormasDeExtracao;
import Corrida.br.com.front.TelaInicial;

public class Main {
	
	public static void main(String[] args) {
		new TelaInicial().boasVindas();
		FormasDeExtracao formaDeExtracao = new FormaDeComoExtraiAInformacaoDoLog().pegaForma();
	}
	
}
