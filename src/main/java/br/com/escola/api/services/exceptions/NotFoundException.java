package br.com.escola.api.services.exceptions;

public class NotFoundException extends  RuntimeException{

    private  static final Long serialVersionUID = 1L;


    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
