package br.com.escola.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.api.dto.FuncionarioDto;
import br.com.escola.api.model.Funcionario;
import br.com.escola.api.repository.FuncionarioRepository;
import br.com.escola.api.services.exceptions.NotFoundException;

@Service
public class FuncionarioServices {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	//Cadastra Funcionário
	public FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto) {
		Funcionario funcionario = new Funcionario(funcionarioDto);
		Funcionario funcionarioSalvo = this.funcionarioRepository.save(funcionario);
		if (funcionarioSalvo != null) {
			return new FuncionarioDto(funcionarioSalvo);
		} else {
			throw new NotFoundException("Erro ao tentar salvar funcionario!");
		}
	}
	
	//Busca todos os Funcionários
	public List<FuncionarioDto> listarTodosFuncionarios() {	
		List<Funcionario> listaFuncionario = (List<Funcionario>) this.funcionarioRepository.findAll();
	      List<FuncionarioDto> funcionarioDtoLista = listaFuncionario.stream()
	              .map(Funcionario -> new FuncionarioDto(Funcionario))
	              .collect(Collectors.toList());
	      return funcionarioDtoLista;
	}
	
	//Buscar Funcionário por Id
	public FuncionarioDto funcionarioPorId(Long idFuncionario) {
		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new NotFoundException("Funcionário não encontrado!") );
		FuncionarioDto funcionarioDto = new FuncionarioDto(funcionario);
		return funcionarioDto;
	}
	
	//Atualiza Funcionario
	public FuncionarioDto atualizaFuncionario(FuncionarioDto funcionarioDto, Long id) {
		//Optional<FuncionarioDto> funcionarioDtoLocalizado = this.funcionarioPorId(id);
		
		Optional<Funcionario> funcionarioLocalizado = this.funcionarioRepository.findById(id);
		
		//Se existe o funcionario cadastrado, então atualiza.
		if (funcionarioLocalizado.isPresent()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setCdFuncionario(id);
			funcionario.setNome(funcionarioDto.getNome());
			funcionario.setCpf(funcionarioDto.getCpf());
			funcionario.setDtCadastro(funcionarioDto.getDtCadastro());
			
			this.funcionarioRepository.save(funcionario);
			return new FuncionarioDto(funcionario);
		} else {
			throw new NotFoundException("Funcionario não encontrado!");
		}
	}
	
	
	//Deleta Funcionario
	public List<FuncionarioDto> deletaFuncionario(Long id) {
		Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
		if (funcionario.isPresent()) {
			this.funcionarioRepository.deleteById(id);
		} else {
			throw new NotFoundException("Funcionario não encontrado!");
		}
		return this.listarTodosFuncionarios();
		
	}
}



