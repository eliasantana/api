package br.com.escola.api.dto;

import br.com.escola.api.model.Aluno;

import br.com.escola.api.model.CadEscola;
import br.com.escola.api.model.Notas;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDto {

    private String cdAluno;

    @NotNull(message = "O nome do aluno é Requerido")
    private String nome;
    @NotNull(message = "O CPF deve ser informado")
    private String cpf;
    private String dtCadastro;
    @NotNull(message = "Informe o Status do Aluno")
    private String snAtivo;

    private List<Notas> notas = new ArrayList<>();



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

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        return "AlunoDto{" +
                "cdAluno='" + cdAluno + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dtCadastro='" + dtCadastro + '\'' +
                ", snAtivo='" + snAtivo + '\'' +
                ", notas=" + notas +
                '}';
    }
}
