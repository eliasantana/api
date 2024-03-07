package br.com.escola.api.repository;

import br.com.escola.api.model.DisciplinaProfessor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplinaProfessorRepository extends CrudRepository<DisciplinaProfessor, Long> {
    @Query(value = "select * from disciplina_professor where cd_disciplina =:idDisciplina and cd_professor =:idProfessor",nativeQuery = true)
    Optional<DisciplinaProfessor> getDisciplinaProfessor(Long idDisciplina, Long idProfessor);

   // @Query(value = "select  * from disciplina_professor where cd_professor=:idprofessor",nativeQuery = true)
    @Query(value = "select p.* from disciplina_professor p, disciplina d where p.cd_disciplina = d.cd_disciplina and p.cd_professor =:idprofessor and d.sn_ativo='S'",nativeQuery = true)
    List<DisciplinaProfessor> getDisciplinaPorProfessor(Long idprofessor);
}
