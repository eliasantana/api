package br.com.escola.api.model;

import br.com.escola.api.dto.TurmaProfessorDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "turma_professor")
public class TurmaProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdTurmaProfessor;
    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Turma turma;

    private LocalDate dtInclusao;

    public TurmaProfessor(){
        this.dtInclusao = LocalDate.now();
    }
    public TurmaProfessor(TurmaProfessorDto dto) {
        this.cdTurmaProfessor = dto.getCdTurmaProfessor();
        this.professor = dto.getProfessor();
        this.turma = dto.getTurma();
        this.dtInclusao = LocalDate.now();
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

    public void setDtInclusao(LocalDate dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public LocalDate getDtInclusao() {
        return dtInclusao;
    }

    @Override
    public String toString() {
        return "TurmaProfessor{" +
                "cdTurmaProfessor=" + cdTurmaProfessor +
                ", professor=" + professor +
                ", turma=" + turma +
                ", dtInclusao=" + dtInclusao +
                '}';
    }
}
