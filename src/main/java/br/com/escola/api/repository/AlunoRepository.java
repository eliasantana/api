package br.com.escola.api.repository;

import br.com.escola.api.model.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    @Query(value = "select * from aluno where cd_aluno=:id", nativeQuery = true)
    Aluno localizarAluno(Long id);

    @Query(value = "Select * from aluno",nativeQuery = true)
    List<Aluno> listarTodos();
    @Query(value = "select a.* from aluno a, matricula m where a.cd_aluno = m.cd_aluno and m.status ='M' and sn_ativo = 'S'",nativeQuery = true)
    List<Aluno> alnosMatriculados();

    @Query(value = "select * from aluno where cpf=:cpf", nativeQuery = true)
    Optional<Aluno> localizarAlunoPorCpf(Long cpf);

    @Query(value = "select * from aluno where escola_cd_escola=:idescola", nativeQuery = true)
    List<Aluno> listarAlunos(Long idescola);
}

