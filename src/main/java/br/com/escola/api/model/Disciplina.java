package br.com.escola.api.model;

import br.com.escola.api.dto.DisciplinaDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdDisciplina;
    @Column(unique = true)
    private String nome;
    private LocalDate dtCadastro;
    private String snAtivo;

    private double cargaHoraria;

    public Disciplina(){}

    public Disciplina(DisciplinaDto dto){
        this.cdDisciplina = dto.getCdDisciplina();
        this.nome = dto.getNome();
        this.snAtivo = dto.getSnAtivo();
        this.cargaHoraria = dto.getCargaHoraria();
        this.dtCadastro = dto.getDtCadastro();

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
