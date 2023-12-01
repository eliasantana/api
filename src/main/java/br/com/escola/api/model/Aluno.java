package br.com.escola.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdAluno;
    private String nome;
    private int cpf;
    private LocalDate dtCadastro;
    private String snAtivo;

    Aluno(){

    }

    public Aluno(String nome, int cpf, LocalDate dtCadastro, String snAtivo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtCadastro = dtCadastro;
        this.snAtivo = snAtivo;
    }

    public Long getCdAluno() {
        return cdAluno;
    }

    public void setCdAluno(Long cdAluno) {
        this.cdAluno = cdAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
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


}
