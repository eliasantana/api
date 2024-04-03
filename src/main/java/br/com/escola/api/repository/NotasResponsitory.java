package br.com.escola.api.repository;

import br.com.escola.api.model.Notas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasResponsitory extends CrudRepository<Notas, Long> {

    @Query(value = "select * from notas where cd_aluno=:idaluno",nativeQuery = true)
    List<Notas> listarNotas(Long idaluno);

    @Query(value = "select * from notas where cd_aluno=:idaluno and cd_disciplina=:iddsciplina",nativeQuery = true)
    List<Notas> listarNotas(Long idaluno, Long iddsciplina);
}
