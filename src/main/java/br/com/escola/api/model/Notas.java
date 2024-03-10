package br.com.escola.api.model;

import br.com.escola.api.enumerator.TipoNota;
import io.micrometer.observation.Observation;
import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdNotas;
    @ManyToOne
    @JoinColumn(name = "cd_aluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "cd_matricula")
    private Matricula matricula;
    @ManyToOne
    @JoinColumn(name = "cd_disciplina")
    private Disciplina disciplina;

    private Double nota;

    private TipoNota tipoNota;

    private String observacao;

    public Notas(){}

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

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public void setTipoNota(TipoNota tipoNota) {
        this.tipoNota = tipoNota;
    }

    public TipoNota getTipoNota() {
        return tipoNota;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "cdNotas=" + cdNotas +
                ", aluno=" + aluno +
                ", matricula=" + matricula +
                ", disciplina=" + disciplina +
                ", nota=" + nota +
                ", tipoNota=" + tipoNota +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
