package br.com.escola.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.escola.api.model.Funcionario;

public class FuncionarioDto {

	public FuncionarioDto() {	
	}
	
	public FuncionarioDto(Funcionario funcionario) {
		this.cdFuncionario = funcionario.getCdFuncionario();
		this.nome = funcionario.getNome();
		if(funcionario.getDtCadastro() != null) {
			this.dtCadastro = funcionario.getDtCadastro();
		} else {
			this.dtCadastro = LocalDateTime.now();
		}
		this.dtCadastro = funcionario.getDtCadastro();
		this.cpf = funcionario.getCpf();
	}
	
	public FuncionarioDto(List<Funcionario> funcionarioList) {	
		this.funcionarioLista = funcionarioList;
	}
	
	private Long cdFuncionario;
	private String nome;
	private LocalDateTime dtCadastro;
	private String cpf;
	
	List<Funcionario> funcionarioLista;
	
	public Long getCdFuncionario() {
		return cdFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}


	public String getCpf() {
		return cpf;
	}
	
}
