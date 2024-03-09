package br.com.escola.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.escola.api.model.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

    @Query(value = "select * from funcionario",nativeQuery = true)
    List<Funcionario> getTodosFuncionario();
}
