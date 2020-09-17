package Corrida.br.com.front;

public class TelaInicial {
	
	public void opcoesDeFormaDeExtracaoDoLog() {
		System.out.println("Escolha a maneira de onde deseja obter as informações do log:");
		System.out.println("1 - Local");
		System.out.println("2 - Externo");
		System.out.println("3 - Encerrar sistema");
		System.out.print("R: ");
	}

	public void numeroDeTentativaExcedida() {
		System.out.println("Número de tentativas excedidas... O sistema será encerrado!");		
	}

	public void digitouErrado() {
		System.out.println("Você digitou algo errado. Por favor, tente novamente \n");
	}

	public void sairDoSistema() {
		System.out.println("Você escolheu encerrar o sistema. Muito obrigado!!");		
	}

	public void boasVindas() {
		System.out.println("Bem vindo leitor de log!");		
	}

}
