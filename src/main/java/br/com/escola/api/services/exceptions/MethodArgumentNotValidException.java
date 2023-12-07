package br.com.escola.api.services.exceptions;

public class MethodArgumentNotValidException  extends RuntimeException{
    public MethodArgumentNotValidException(String message) {
        super(message);
    }

    public MethodArgumentNotValidException(Throwable cause) {
        super(cause);
    }
}
