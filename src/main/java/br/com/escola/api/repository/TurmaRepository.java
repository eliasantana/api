package br.com.escola.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.escola.api.model.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long> {

}
