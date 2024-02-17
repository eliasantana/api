package br.com.escola.api.repository;

import br.com.escola.api.model.TurmaProfessor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaProfessorRepository extends CrudRepository<TurmaProfessor, Long> {

    @Query(value = "select * from turma_professor where professor_cd_professor=:idprofessor and turma_cd_turma=:idturma", nativeQuery = true)
    Optional<TurmaProfessor> existTurmaProfessor(Long idturma, Long idprofessor);
    @Query(value = "select * from turma_professor where turma_cd_turma=:idturma", nativeQuery = true)
    List<TurmaProfessor> listarProfessor(Long idturma);
}
