package br.com.escola.api.dto;

import br.com.escola.api.model.Aluno;

import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public class AlunoDto {

    private String cdAluno;

    @NotNull(message = "O nome do aluno é Requerido")
    private String nome;
    @NotNull(message = "O CPF deve ser informado")
    private String cpf;
    private String dtCadastro;
    @NotNull(message = "Informe o Status do Aluno")
    private String snAtivo;

    public AlunoDto(){}
    public AlunoDto( Aluno aluno){
        this.cdAluno = String.valueOf(aluno.getCdAluno());
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf().toString();
        this.dtCadastro = LocalDate.now().toString();
        this.snAtivo = aluno.getSnAtivo();

    }


    public String getCdAluno() {
        return cdAluno;
    }

    public String getNome() {
        return nome;
    }

    public @NotNull(message = "O CPF deve ser informado")
    String getCpf() {
        return cpf;
    }

    public String getDtCadastro() {
        return dtCadastro;
    }

    public String getSnAtivo() {
        return snAtivo;
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
