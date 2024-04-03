package br.com.escola.api.services.exceptions;

public class NotasException extends RuntimeException{
    public NotasException(String message) {
        super(message);
    }

    public NotasException(Throwable cause) {
        super(cause);
    }
}
