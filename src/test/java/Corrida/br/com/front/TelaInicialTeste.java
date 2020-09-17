package Corrida.br.com.front;

import org.junit.BeforeClass;
import org.junit.Test;

public class TelaInicialTeste {
	
	private static TelaInicial telaInicial;
	
	@BeforeClass
	public static void iniciaAntes() {
		telaInicial = new TelaInicial();
	}
	
	@Test
	public void exibeOpcoesDeFormaDeExtracaoDoLog_exibeTexto() {
		telaInicial.opcoesDeFormaDeExtracaoDoLog();
	}
	
	@Test
	public void numeroDeTentativaExcedida_exibeTexto() {
		telaInicial.numeroDeTentativaExcedida();
	}
	
	@Test
	public void digitouErrado_exibeTexto() {
		telaInicial.digitouErrado();
	}
	
	@Test
	public void sairDoSistema_exibeTexto() {
		telaInicial.sairDoSistema();
	}
	
	@Test
	public void boasVindas_exibeTexto() {
		telaInicial.boasVindas();
	}

}
