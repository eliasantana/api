package br.com.escola.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.escola.api.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

}
