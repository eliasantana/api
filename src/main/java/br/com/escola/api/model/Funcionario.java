package br.com.escola.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdFuncionario;
	private String nome;
	private LocalDateTime dtCadastro;
	private int cpf;
	
	public Funcionario () {
		
	}

	public Funcionario(Long cdFuncionario, String nome, LocalDateTime dtCadastro, int cpf) {
		this.cdFuncionario = cdFuncionario;
		this.nome = nome;
		this.dtCadastro = dtCadastro;
		this.cpf = cpf;
	}

	public Long getCdFuncionario() {
		return cdFuncionario;
	}

	public void setCdFuncionario(Long cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
	
	

}
