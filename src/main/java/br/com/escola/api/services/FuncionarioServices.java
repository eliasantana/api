package br.com.escola.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.escola.api.dto.FuncionarioDto;
import br.com.escola.api.model.Funcionario;
import br.com.escola.api.repository.FuncionarioRepository;

@Service
public class FuncionarioServices {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	//Cadastra Funcionário
	public FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto) {
		Funcionario funcionario = new Funcionario(funcionarioDto);
		Funcionario funcionarioSalvo = this.funcionarioRepository.save(funcionario);
		
		return new FuncionarioDto(funcionarioSalvo);
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
	public FuncionarioDto funcionarioPorId(Long idFuncionario) throws Exception {
		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new Exception("Funcionário não encontrado!") );
		FuncionarioDto funcionarioDto = new FuncionarioDto(funcionario);
		return funcionarioDto;
	}
	
	//Atualiza Funcionario
	public FuncionarioDto atualizaFuncionario(FuncionarioDto funcionarioDto, Long id) throws Exception {
		FuncionarioDto funcionarioDtoLocalizado = this.funcionarioPorId(id);
		
		//Se existe o funcionario cadastrado, então atualiza.
		if (funcionarioDtoLocalizado != null) {
			Funcionario funcionario = new Funcionario();
			funcionario.setCdFuncionario(id);
			funcionario.setNome(funcionarioDto.getNome());
			funcionario.setCpf(funcionarioDto.getCpf());
			funcionario.setDtCadastro(funcionarioDto.getDtCadastro());
			
			this.funcionarioRepository.save(funcionario);
			return new FuncionarioDto(funcionario);
		} else {
			throw new Exception("Funcionario não encontrado!");
		}
	}
	
	
	//Deleta Funcionario
	public List<FuncionarioDto> deletaFuncionario(Long id) throws Exception {
		FuncionarioDto funcionarioDto = this.funcionarioPorId(id);
		if (funcionarioDto != null) {
			this.funcionarioRepository.deleteById(id);
		} else {
			throw new Exception("Funcionario não encontrado!");
		}
		return this.listarTodosFuncionarios();
		
	}
}



