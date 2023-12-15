package br.com.escola.api.dto;

import br.com.escola.api.model.Disciplina;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class DisciplinaDto {

    private Long cdDisciplina;
    @NotNull(message = "O campo nome é obrigatório!")
    private String nome;

    private LocalDate dtCadastro;
    private String snAtivo="S";
    @NotNull(message = "O campo data de Cadastro é Obrigatório!")
    private double cargaHoraria;

    DisciplinaDto(){}
    public DisciplinaDto(Disciplina disciplina){
        this.cdDisciplina = disciplina.getCdDisciplina();
        this.nome = disciplina.getNome();
        this.dtCadastro = disciplina.getDtCadastro();
        this.snAtivo = disciplina.getSnAtivo();
        this.cargaHoraria = disciplina.getCargaHoraria();

    }

    public Long getCdDisciplina() {
        return cdDisciplina;
    }

    public void setCdDisciplina(Long cdDisciplina) {
        this.cdDisciplina = cdDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getSnAtivo() {
        return snAtivo;
    }

    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "DisciplinaDto{" +
                "cdDisciplina=" + cdDisciplina +
                ", nome='" + nome + '\'' +
                ", dtCadastro=" + dtCadastro +
                ", snAtivo='" + snAtivo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
