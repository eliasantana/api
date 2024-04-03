package br.com.escola.api.services.exceptions;

public class DisciplinaException extends RuntimeException {
    public DisciplinaException(String message) {
        super(message);
    }

    public DisciplinaException(Throwable cause) {
        super(cause);
    }
}
