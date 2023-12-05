package br.com.escola.api.repository;

import br.com.escola.api.model.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {

    @Query(value = "Select * from professor",nativeQuery = true)
    List<Professor> listartodos();
    @Query(value = "Select * from professor where cd_professor=:id",nativeQuery = true)
    Professor localizar(Long id);
}
