package br.com.escola.api.dto;

import br.com.escola.api.model.Aluno;

import java.time.LocalDate;

public class AlunoDto {


    private Long cdAluno;
    private String nome;
    private Long cpf;
    private LocalDate dtCadastro;
    private String snAtivo;

    public AlunoDto(){

    }
    public void setCdAluno(Long cdAluno) {
        this.cdAluno = cdAluno;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public void setSnAtivo(String snAtivo) {
        this.snAtivo = snAtivo;
    }

    public Long getCdAluno() {
        return cdAluno;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public String getSnAtivo() {
        return snAtivo;
    }

    public Aluno convertToAluno(){
        return new Aluno(this.cdAluno,
                this.nome,
                this.cpf,
                this.dtCadastro,
                LocalDate.now(),
                this.snAtivo);
    }

    @Override
    public String toString() {
        return "AlunoDto{" +
                "cdAluno=" + cdAluno +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dtCadastro=" + dtCadastro +
                ", snAtivo='" + snAtivo + '\'' +
                '}';
    }
}
