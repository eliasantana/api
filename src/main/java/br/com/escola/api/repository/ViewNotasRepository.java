package br.com.escola.api.repository;

import br.com.escola.api.model.ViewNotas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewNotasRepository extends CrudRepository<ViewNotas, Long> {

    @Query(value = " select * from view_notas where cd_aluno=:cdaluno", nativeQuery = true)
    List<ViewNotas> getNotasAluno(Long cdaluno);

}
