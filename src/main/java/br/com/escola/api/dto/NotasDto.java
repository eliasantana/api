package br.com.escola.api.dto;

import br.com.escola.api.enumerator.TipoNota;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.Disciplina;
import br.com.escola.api.model.Matricula;
import br.com.escola.api.model.Notas;
import jakarta.persistence.*;

public class NotasDto {

    private Long cdNotas;
    private Aluno aluno;
    private Matricula matricula;
    private Disciplina disciplina;

    private TipoNota tipoNota;

    public NotasDto(){}

    public NotasDto(Notas nota) {
        this.cdNotas = nota.getCdNotas();
        this.aluno = nota.getAluno();
        this.matricula = nota.getMatricula();
        this.disciplina = nota.getDisciplina();
        this.tipoNota = nota.getTipoNota();
    }

    public Long getCdNotas() {
        return cdNotas;
    }

    public void setCdNotas(Long cdNotas) {
        this.cdNotas = cdNotas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setTipoNota(TipoNota tipoNota) {
        this.tipoNota = tipoNota;
    }

    public TipoNota getTipoNota() {
        return tipoNota;
    }

    @Override
    public String toString() {
        return "NotasDto{" +
                "cdNotas=" + cdNotas +
                ", aluno=" + aluno +
                ", matricula=" + matricula +
                ", disciplina=" + disciplina +
                ", tipoNota="+tipoNota.toString()+
                '}';
    }
}
