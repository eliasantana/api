package br.com.escola.api.services.exceptions;

public class MatriculaException extends  RuntimeException{
    public MatriculaException(String message) {
        super(message);
    }

    public MatriculaException(Throwable cause) {
        super(cause);
    }
}
