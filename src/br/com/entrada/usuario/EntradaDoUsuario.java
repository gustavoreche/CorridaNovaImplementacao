package br.com.entrada.usuario;

import java.util.Scanner;

public class EntradaDoUsuario {
	
	public String digitado() {
		@SuppressWarnings("resource")
		Scanner entradaDoUsuario = new Scanner(System.in);
		return entradaDoUsuario.nextLine();		
	}
	
}
