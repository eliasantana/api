package br.com.escola.api.model;

import br.com.escola.api.dto.CadEscolaDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cad_escola")
public class CadEscola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdEscola;
    @NotNull
    private String nmEscola;
    @NotNull
    private LocalDate dtInclusao;
    private String endereco;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    @NotNull
    private String razaoSocial;
    @NotNull
    private String cnPj;
    @NotNull
    private String telefone;
    @NotNull
    private String email;
    private int limiteAlunoTurma;
    @OneToMany
    @JoinColumn(name = "cd_aluno_escola")
    private List<Aluno> aluno  = new ArrayList<>();

    public CadEscola(){}
    public CadEscola(CadEscolaDto dto){
        this.cdEscola = dto.getCdEscola();
        this.nmEscola = dto.getNmEscola();
        this.dtInclusao = LocalDate.now();
        this.endereco = dto.getEndereco();
        this.bairro = dto.getBairro();
        this.cep = dto.getCep();
        this.cidade = dto.getUf();
        this.uf = dto.getUf();
        this.razaoSocial = dto.getRazaoSocial();
        this.cnPj = dto.getCnPj();
        this.telefone = dto.getTelefone();
        this.endereco = dto.getEndereco();
        this.email = dto.getEmail();
        this.limiteAlunoTurma = dto.getLimiteAlunoTurma();

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

    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    @Override
    public String toString() {
        return "CadEscola{" +
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
                ", aluno=" + aluno +
                '}';
    }
}
