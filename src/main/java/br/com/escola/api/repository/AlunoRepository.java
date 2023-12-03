package br.com.escola.api.repository;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.model.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    @Query(value = "select * from aluno where cd_aluno=:id", nativeQuery = true)
    Aluno localizarAluno(Long id);

    @Query(value = "Select * from aluno",nativeQuery = true)
    List<Aluno> listarTodos();
}

