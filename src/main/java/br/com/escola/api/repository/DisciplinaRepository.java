package br.com.escola.api.repository;

import br.com.escola.api.model.Disciplina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {

    @Query(value = "Select * from disciplina", nativeQuery = true)
    List<Disciplina> localizarTodas();

    @Query(value = "Select * from disciplina where nome=:nome", nativeQuery = true)
    Optional<Disciplina> getDisciplina(String nome);

}
