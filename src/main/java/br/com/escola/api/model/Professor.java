package br.com.escola.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Professor")

public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdProfessor;
    private String nome;

    public Professor(){}

    public Professor(Long cdProfessor, String nome){
        this.cdProfessor = cdProfessor;
        this.nome = nome;
    }

    public Long getCdProfessor() {
        return cdProfessor;
    }

    public void setCdProfessor(Long cdProfessor) {
        this.cdProfessor = cdProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "cdProfessor=" + cdProfessor +
                ", nome='" + nome + '\'' +
                '}';
    }
}
