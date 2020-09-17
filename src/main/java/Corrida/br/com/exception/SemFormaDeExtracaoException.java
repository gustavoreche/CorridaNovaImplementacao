package Corrida.br.com.exception;

public class SemFormaDeExtracaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SemFormaDeExtracaoException() {
		super("Forma de extração do log inválida!!");
	}

}
