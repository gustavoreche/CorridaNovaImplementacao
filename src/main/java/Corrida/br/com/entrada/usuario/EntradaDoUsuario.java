package Corrida.br.com.entrada.usuario;

import java.util.Scanner;

public class EntradaDoUsuario {
	
	public String pega() {
		@SuppressWarnings("resource")
		Scanner entradaDoUsuario = new Scanner(System.in);
		return entradaDoUsuario.nextLine();		
	}
	
}
