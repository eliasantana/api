package br.com.escola.api.dto;

import br.com.escola.api.model.Professor;
import br.com.escola.api.model.Turma;
import br.com.escola.api.model.TurmaProfessor;

import java.time.LocalDate;

public class TurmaProfessorDto {

    private Long cdTurmaProfessor;

    private Professor professor;

    private Turma turma;
    private LocalDate dtInclusao;

    public TurmaProfessorDto(TurmaProfessor tp){
        this.cdTurmaProfessor = tp.getCdTurmaProfessor();
        this.professor = tp.getProfessor();
        this.turma = tp.getTurma();
        this.dtInclusao = tp.getDtInclusao();
    }

    public Long getCdTurmaProfessor() {
        return cdTurmaProfessor;
    }

    public void setCdTurmaProfessor(Long cdTurmaProfessor) {
        this.cdTurmaProfessor = cdTurmaProfessor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public LocalDate getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(LocalDate dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    @Override
    public String toString() {
        return "TurmaProfessorDto{" +
                "cdTurmaProfessor=" + cdTurmaProfessor +
                ", professor=" + professor +
                ", turma=" + turma +
                ", dtInclusao=" + dtInclusao +
                '}';
    }
}
