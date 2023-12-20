package br.com.escola.api.model;

import br.com.escola.api.dto.MatriculaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdMatricula;
    @Column(unique = true)
    private String localizador;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cd_aluno")
    private Aluno aluno;
    private LocalDate dtMatricula;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cd_funcionario")
    private Funcionario funcionario;
    private String status;

    public Matricula(){}

    Matricula(MatriculaDto dto){
        this.cdMatricula = dto.getCdMatricula();
        this.localizador = dto.getLocalizador();
        this.aluno = dto.getAluno();
        this.dtMatricula = dto.getDtMatricula();
        this.funcionario = dto.getFuncionario();
        this.status = dto.getStatus();
    }

    public Long getCdMatricula() {
        return cdMatricula;
    }

    public void setCdMatricula(Long cdMatricula) {
        this.cdMatricula = cdMatricula;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDate getDtMatricula() {
        return dtMatricula;
    }

    public void setDtMatricula(LocalDate dtMatricula) {
        this.dtMatricula = dtMatricula;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "cdMatricula=" + cdMatricula +
                ", localizador='" + localizador + '\'' +
                ", aluno=" + aluno +
                ", dtMatricula=" + dtMatricula +
                ", funcionario=" + funcionario +
                ", Status='" + status + '\'' +
                '}';
    }
}
