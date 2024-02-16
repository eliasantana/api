package br.com.escola.api.model;

import br.com.escola.api.dto.AlunoTurmaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aluno_turma")
public class AlunoTurma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cdAlunoTurma;

    @ManyToOne
    @NotNull(message = "É necessário informar um Aluno!")
    private Aluno aluno;
    @ManyToOne
    @NotNull(message = "É necessário informar uma Turma!")
    private Turma turma;

    public AlunoTurma(){}
    public AlunoTurma(AlunoTurmaDto dto){
        this.turma = dto.getTurma();
        this.aluno = dto.getAluno();
    }

    public long getCdAlunoTurma() {
        return cdAlunoTurma;
    }

    public void setCdAlunoTurma(long cdAlunoTurma) {
        this.cdAlunoTurma = cdAlunoTurma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "AlunoTurma{" +
                "cdAlunoTurma=" + cdAlunoTurma +
                ", aluno=" + aluno +
                ", tumrma=" + turma +
                '}';
    }
}
