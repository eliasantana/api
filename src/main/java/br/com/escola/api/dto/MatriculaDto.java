package br.com.escola.api.dto;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.Funcionario;
import br.com.escola.api.model.Matricula;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MatriculaDto {

    private Long cdMatricula;
    @NotNull(message = "O campo localizador é obrigatório!")
    private String localizador;
    @NotNull(message = "A matrícula deve está associada a uma aluno!")
    private Aluno aluno;
    @NotNull(message = "O campo data de matrícula é obrigatório")
    private LocalDate dtMatricula;
    @NotNull(message = "A matrícula deve estar associado a um funcionário")
    private Funcionario funcionario;
    private String status="M";

    MatriculaDto(){}

    public MatriculaDto(Matricula matricula){
        this.cdMatricula = matricula.getCdMatricula();
        this.aluno = matricula.getAluno();
        this.localizador = matricula.getLocalizador();
        this.dtMatricula = matricula.getDtMatricula();
        this.funcionario = matricula.getFuncionario();
        this.status = matricula.getStatus();
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
        return "MatriculaDto{" +
                "cdMatricula=" + cdMatricula +
                ", localizador='" + localizador + '\'' +
                ", aluno=" + aluno +
                ", dtMatricula=" + dtMatricula +
                ", funcionario=" + funcionario +
                ", Status='" + status + '\'' +
                '}';
    }
}
