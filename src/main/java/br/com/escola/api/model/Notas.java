package br.com.escola.api.model;

import br.com.escola.api.dto.NotasDto;
import br.com.escola.api.enumerator.TipoNota;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.validator.internal.metadata.aggregated.rule.ReturnValueMayOnlyBeMarkedOnceAsCascadedPerHierarchyLine;

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
    private TipoNota tipoNota;

    public Notas(NotasDto dto) {
        this.cdNotas = dto.getCdNotas();
        this.aluno = dto.getAluno();
        this.matricula = dto.getMatricula();
        this.disciplina = dto.getDisciplina();
        this.tipoNota = dto.getTipoNota();
    }

    private Double nota;
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
                ", tipoNota=" + tipoNota.toString() +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
