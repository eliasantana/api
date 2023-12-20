package br.com.escola.api.services.exceptions;

public class MatriculaExistenteException extends RuntimeException{
    public MatriculaExistenteException(String message) {
        super(message);
    }

    public MatriculaExistenteException(Throwable cause) {
        super(cause);
    }
}
