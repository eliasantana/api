package br.com.escola.api.model;

import br.com.escola.api.dto.AlunoDto;
import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Aluno(){

    }

    public Aluno(Long cdAluno, String nome, Long cpf, LocalDate dtCadastro, LocalDate now, String snAtivo) {
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

    public AlunoDto convertToDto( ){
        AlunoDto alunoDto= new AlunoDto();
        alunoDto.setNome(getNome());
        alunoDto.setCdAluno(getCdAluno());
        alunoDto.setCpf(getCpf());
        alunoDto.setSnAtivo(getSnAtivo());
        alunoDto.setDtCadastro(getDtCadastro());

        return alunoDto;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cdAluno=" + cdAluno +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dtCadastro=" + dtCadastro +
                ", snAtivo='" + snAtivo + '\'' +
                '}';
    }
}
