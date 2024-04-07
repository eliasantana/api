package br.com.escola.api.dto;

import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.CadEscola;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class CadEscolaDto {
    private Long cdEscola;

    private String nmEscola;

    private LocalDate dtInclusao;
    private String endereco;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    private String razaoSocial;

    private String cnPj;

    private String telefone;

    private String email;

    private int limiteAlunoTurma;

  public CadEscolaDto(){}
    public CadEscolaDto(CadEscola cadEscola){

        this.cdEscola = cadEscola.getCdEscola();
        this.nmEscola = cadEscola.getNmEscola();
        this.dtInclusao = LocalDate.now();
        this.endereco = cadEscola.getEndereco();
        this.bairro = cadEscola.getBairro();
        this.cep = cadEscola.getCep();
        this.cidade = cadEscola.getUf();
        this.uf = cadEscola.getUf();
        this.razaoSocial = cadEscola.getRazaoSocial();
        this.cnPj = cadEscola.getCnPj();
        this.telefone = cadEscola.getTelefone();
        this.email = cadEscola.getEmail();
        this.limiteAlunoTurma = cadEscola.getLimiteAlunoTurma();

    }

    public Long getCdEscola() {
        return cdEscola;
    }

    public void setCdEscola(Long cdEscola) {
        this.cdEscola = cdEscola;
    }

    public String getNmEscola() {
        return nmEscola;
    }

    public void setNmEscola(String nmEscola) {
        this.nmEscola = nmEscola;
    }

    public LocalDate getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(LocalDate dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnPj() {
        return cnPj;
    }

    public void setCnPj(String cnPj) {
        this.cnPj = cnPj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLimiteAlunoTurma(int limiteAlunoTurma) {
        this.limiteAlunoTurma = limiteAlunoTurma;
    }

    public int getLimiteAlunoTurma() {
        return limiteAlunoTurma;
    }
    @Override
    public String toString() {
        return "CadEscolaDto{" +
                "cdEscola=" + cdEscola +
                ", nmEscola='" + nmEscola + '\'' +
                ", dtInclusao=" + dtInclusao +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnPj='" + cnPj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", limiteAlunoTurma=" + limiteAlunoTurma +
                '}';
    }
}
