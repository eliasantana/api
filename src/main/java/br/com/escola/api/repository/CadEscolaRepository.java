package br.com.escola.api.repository;

import br.com.escola.api.model.CadEscola;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadEscolaRepository  extends CrudRepository<CadEscola, Long> {
    @Query(value = "select * from cad_escola", nativeQuery = true)
    List<CadEscola> listar();
}
