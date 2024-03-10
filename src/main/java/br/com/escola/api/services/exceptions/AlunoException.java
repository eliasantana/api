package br.com.escola.api.services.exceptions;

public class AlunoException extends RuntimeException{
    public AlunoException(String message) {
        super(message);
    }

    public AlunoException(Throwable cause) {
        super(cause);
    }
}
