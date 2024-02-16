package br.com.escola.api.dto;

import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.AlunoTurma;
import br.com.escola.api.model.Turma;

public class AlunoTurmaDto {
    private Long cdAlunoTurma;
    private Aluno aluno;
    private Turma turma;

    public AlunoTurmaDto( AlunoTurma alunoTurma){
        this.aluno = alunoTurma.getAluno();
        this.turma = alunoTurma.getTurma();
    }

    public Long getCdAlunoTurma() {
        return cdAlunoTurma;
    }

    public void setCdAlunoTurma(Long cdAlunoTurma) {
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
        return "AlunoTurmaDto{" +
                "cdAlunoTurma=" + cdAlunoTurma +
                ", aluno=" + aluno +
                ", turma=" + turma +
                '}';
    }
}
