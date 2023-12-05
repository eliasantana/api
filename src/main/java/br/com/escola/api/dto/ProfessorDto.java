package br.com.escola.api.dto;

import br.com.escola.api.model.Professor;
import jakarta.validation.constraints.NotNull;

public class ProfessorDto {

    private Long cdProfessor;
    @NotNull(message = "O campo nome é obrigatório")
    private String nome;

    public ProfessorDto(){}

    public ProfessorDto(Professor professor){
        this.cdProfessor = professor.getCdProfessor();
        this.nome = professor.getNome();
    }

    public Long getCdProfessor() {
        return cdProfessor;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ProfessorDto{" +
                "cdProfessor=" + cdProfessor +
                ", nome='" + nome + '\'' +
                '}';
    }
}
