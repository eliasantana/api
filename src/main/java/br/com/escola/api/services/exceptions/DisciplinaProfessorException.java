package br.com.escola.api.services.exceptions;

public class DisciplinaProfessorException extends  RuntimeException{
    public DisciplinaProfessorException(String message) {
        super(message);
    }

    public DisciplinaProfessorException(Throwable cause) {
        super(cause);
    }
}
