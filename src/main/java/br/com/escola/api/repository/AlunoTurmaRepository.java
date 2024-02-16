package br.com.escola.api.repository;

import br.com.escola.api.model.AlunoTurma;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoTurmaRepository extends CrudRepository<AlunoTurma, Long> {

    @Query(value = "select * from aluno_turma where aluno_cd_aluno =:idaluno and turma_cd_turma =:idturma",nativeQuery = true)
    Optional<AlunoTurma> existe(Long idaluno, Long idturma);

    @Query(value = "select * from aluno_turma",nativeQuery = true)
    List<AlunoTurma> listar();
    @Query(value = "select * from aluno_turma where aluno_cd_aluno =:idaluno",nativeQuery = true)
    Optional<AlunoTurma> getAlunoTurma(Long idaluno);
    @Query(value = "select * from aluno_turma where turma_cd_turma =:cdturma",nativeQuery = true)
    List<AlunoTurma>listarTurma(Long cdturma);
}
