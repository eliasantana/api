package br.com.escola.api.dto;

import br.com.escola.api.model.Disciplina;
import br.com.escola.api.model.DisciplinaProfessor;
import br.com.escola.api.model.Professor;

public class DisciplinaProfessorDto {
    private Long cdDiscipliaProfessor;
    private Disciplina disciplina;
    private Professor professor;

    public DisciplinaProfessorDto(){

    }

    public Long getCdDiscipliaProfessor() {
        return cdDiscipliaProfessor;
    }
    public DisciplinaProfessorDto(DisciplinaProfessor dp){
        this.professor = dp.getProfessor();
        this.disciplina = dp.getDisciplina();
    }

    public void setCdDiscipliaProfessor(Long cdDiscipliaProfessor) {
        this.cdDiscipliaProfessor = cdDiscipliaProfessor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "DisciplinaProfessorDto{" +
                "cdDiscipliaProfessor=" + cdDiscipliaProfessor +
                ", disciplina=" + disciplina +
                ", professor=" + professor +
                '}';
    }
}
