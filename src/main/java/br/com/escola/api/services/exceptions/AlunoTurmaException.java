package br.com.escola.api.services.exceptions;

public class AlunoTurmaException extends  RuntimeException{
    public AlunoTurmaException(String message) {
        super(message);
    }

    public AlunoTurmaException(Throwable cause) {
        super(cause);
    }
}
