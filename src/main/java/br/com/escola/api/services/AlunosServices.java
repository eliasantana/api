package br.com.escola.api.services;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.dto.AlunoTurmaDto;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.repository.AlunoRepository;

import br.com.escola.api.services.exceptions.MethodArgumentNotValidException;
import br.com.escola.api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunosServices {
    @Autowired
    AlunoRepository repository;

    public AlunoDto create(AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setCdAluno(null);
        aluno.setNome(dto.getNome());
        aluno.setDtCadastro(LocalDate.parse(dto.getDtCadastro()));
        aluno.setCpf(Long.parseLong(dto.getCpf()));
        aluno.setSnAtivo(dto.getSnAtivo());
        Aluno alunoSalvo = repository.save(aluno);
      return new AlunoDto(alunoSalvo);
    }

    public AlunoDto localizar(Long id) {
       Aluno aluno =  repository.localizarAluno(id);
       if (aluno==null){
          throw new NotFoundException("Aluno não localizado : ID "+id);
       }
       return new AlunoDto(aluno);
    }

    public ResponseEntity<AlunoDto> delete(Long id) {
        Optional<Aluno> aluno = repository.findById(id);
        if (aluno.isPresent()){
            repository.deleteById(id);
        }else{
            throw new NotFoundException("Aluno ID % não localizado!");
        }
        return ResponseEntity.noContent().build();
    }

    public AlunoDto update(AlunoDto alunoDto, Long id){

        Aluno alunoAlteracao = null;
        Optional<Aluno> alunoLocalizado = repository.findById(id);

            if (alunoLocalizado.isPresent()) {
                alunoAlteracao = new Aluno();
                alunoAlteracao.setCdAluno(id);
                alunoAlteracao.setNome(alunoDto.getNome());
                alunoAlteracao.setCpf(Long.parseLong(alunoDto.getCpf()));
                if (alunoDto.getDtCadastro()!=null){
                    alunoAlteracao.setDtCadastro(LocalDate.parse(alunoDto.getDtCadastro()));
                }else{
                    alunoAlteracao.setDtCadastro(alunoLocalizado.get().getDtCadastro());
                }
                if(alunoDto.getSnAtivo()!=null){
                    alunoAlteracao.setSnAtivo(alunoDto.getSnAtivo());
                }else{
                    alunoAlteracao.setSnAtivo(alunoLocalizado.get().getSnAtivo());
                }

                repository.save(alunoAlteracao);
            }else{
                throw new NotFoundException(String.format("O aluno ID %s nâo foi localizado ",id));
            }
        return new AlunoDto(alunoAlteracao);
    }

    public List<AlunoDto> ListartTodos() {
      List<Aluno> alunosLista = repository.listarTodos();
      List<AlunoDto> alunosDtoLista = alunosLista.stream()
              .map(aluno -> new AlunoDto(aluno))
              .collect(Collectors.toList());
      return alunosDtoLista;
    }

    public ResponseEntity<List<AlunoDto>> alunosMatriculados() {
       List<Aluno> alunosMatriculados = repository.alnosMatriculados();
       List<AlunoDto> listDto=alunosMatriculados.stream()
               .map(aluno -> new AlunoDto(aluno))
               .collect(Collectors.toList());
       return ResponseEntity.ok(listDto);
    }
}
