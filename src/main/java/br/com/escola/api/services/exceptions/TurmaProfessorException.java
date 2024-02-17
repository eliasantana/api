package br.com.escola.api.services.exceptions;

public class TurmaProfessorException extends RuntimeException{
    public TurmaProfessorException(String message) {
        super(message);
    }

    public TurmaProfessorException(Throwable cause) {
        super(cause);
    }
}
