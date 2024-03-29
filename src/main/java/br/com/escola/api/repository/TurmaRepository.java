package br.com.escola.api.repository;

import java.util.List;

import br.com.escola.api.dto.TurmaDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.escola.api.model.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long> {

	@Query(value = "select * from turma where cd_turma=:cdTurma", nativeQuery = true)
    Turma localizarTurma(Long cdTurma);
	
	@Query(value = "select * from turma", nativeQuery = true)
    List<Turma> listaDeTurmas();

    @Query(value = "select * from turma where ds_turma=:dsturma and local =:local", nativeQuery = true)
    Turma exists(String dsturma, String local);
}
