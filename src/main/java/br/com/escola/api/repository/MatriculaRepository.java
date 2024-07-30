package br.com.escola.api.repository;

import br.com.escola.api.dto.MatriculaDto;
import br.com.escola.api.model.Matricula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long>{

    @Query(value = "SELECT * FROM matricula where cd_aluno=:cdaluno and date_format(dt_matricula,'%Y')=date_format(curdate(),'%Y');", nativeQuery = true)
    Optional<Matricula> getMatriculaAtual(Long cdaluno);
    @Query(value = "SELECT * FROM matricula where localizador=:localizador and date_format(dt_matricula,'%Y')=date_format(curdate(),'%Y');", nativeQuery = true)
    Optional<Matricula> getMatriculaAtual(String localizador);

    @Query(value = "SELECT * FROM matricula where localizador=:localizador", nativeQuery = true)
    Optional<Matricula> getMatricula(String localizador);

    @Query(value = "SELECT * FROM matricula where cd_aluno=:cdaluno and status='M'", nativeQuery = true)
    Optional<Matricula> getMatriculaAluno(long cdaluno);
}
