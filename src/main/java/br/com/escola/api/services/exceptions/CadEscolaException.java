package br.com.escola.api.services.exceptions;

public class CadEscolaException extends RuntimeException{
    public CadEscolaException(String message) {
        super(message);
    }

    public CadEscolaException(Throwable cause) {
        super(cause);
    }
}
