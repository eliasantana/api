package br.com.escola.api.services.exceptions;

public class DataIntegrityViolationException extends  RuntimeException{
    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(Throwable cause) {
        super(cause);
    }
}
