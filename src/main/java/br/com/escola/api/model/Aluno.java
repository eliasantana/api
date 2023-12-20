package br.com.escola.api.model;

import jakarta.persistence.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdAluno;
    private String nome;
    private Long cpf;
    private LocalDate dtCadastro;
    private String snAtivo;
    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matricula = new ArrayList<>();

    public Aluno(){

    }

    public Aluno(Long cdAluno, String nome, Long cpf, LocalDate dtCadastro,  String snAtivo) {
        this.cdAluno = cdAluno;
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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
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

    public void setMatricula(List<Matricula> matricula) {
        this.matricula = matricula;
    }

    public List<Matricula> getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cdAluno=" + cdAluno +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dtCadastro=" + dtCadastro +
                ", snAtivo='" + snAtivo + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
