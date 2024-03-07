package br.com.escola.api.model;

import br.com.escola.api.dto.DisciplinaProfessorDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.mapping.Join;

@Entity
@Table(name = "disciplina_professor")
public class DisciplinaProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdDiscipliaProfessor;
    @ManyToOne
    @JoinColumn(name = "cd_disciplina")
    private Disciplina disciplina;
    @ManyToOne
    @JoinColumn(name = "cd_professor")
    private Professor professor;

    public DisciplinaProfessor(){


    }

    public DisciplinaProfessor(DisciplinaProfessorDto dto){
        this.professor = dto.getProfessor();
        this.disciplina = dto.getDisciplina();
    }

    public Long getCdDiscipliaProfessor() {
        return cdDiscipliaProfessor;
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
        return "DisciplinaProfessor{" +
                "cdDiscipliaProfessor=" + cdDiscipliaProfessor +
                ", disciplina=" + disciplina +
                ", professor=" + professor +
                '}';
    }
}
