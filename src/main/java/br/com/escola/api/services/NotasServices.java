package br.com.escola.api.services;

import br.com.escola.api.dto.NotasDto;
import br.com.escola.api.enumerator.TipoNota;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.Disciplina;
import br.com.escola.api.model.Matricula;
import br.com.escola.api.model.Notas;
import br.com.escola.api.repository.AlunoRepository;
import br.com.escola.api.repository.DisciplinaRepository;
import br.com.escola.api.repository.MatriculaRepository;
import br.com.escola.api.repository.NotasResponsitory;
import br.com.escola.api.services.exceptions.AlunoException;
import br.com.escola.api.services.exceptions.DisciplinaException;
import br.com.escola.api.services.exceptions.MatriculaException;
import br.com.escola.api.services.exceptions.NotasException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotasServices {
    @Autowired
    NotasResponsitory repository;

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    MatriculaRepository matriculaRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;
    public ResponseEntity<NotasDto> adicionar(Long idaluno, Long iddisciplina, Double nota, int tipoNota) {
       Aluno aluno = alunoRepository.localizarAluno(idaluno);

       if (aluno!=null){
           Optional<Matricula> matriculaLocalizada = matriculaRepository.getMatriculaAtual(idaluno);
           Optional<Disciplina> disciplinaLocalizada = disciplinaRepository.findById(iddisciplina);

           if (matriculaLocalizada.isPresent()){
               if (disciplinaLocalizada.isPresent()){
                   Notas n = new Notas();
                   n.setAluno(aluno);
                   n.setDisciplina(disciplinaLocalizada.get());
                   n.setMatricula(matriculaLocalizada.get());
                   // 0-PROVA 1-TESTE
                   if (tipoNota==0){
                       n.setTipoNota(TipoNota.PROVA);
                   }else{
                       n.setTipoNota(TipoNota.TESTE);
                   }
                   n.setNota(nota);

                   Notas notaSalva =repository.save(n);
                   //return  ResponseEntity.ok(new NotasDto(notaSalva));
                   return ResponseEntity.noContent().build();
               }else{
                   throw new DisciplinaException(String.format("Disciplina de ID %s não foi localizada!",iddisciplina));
               }
           }else{
               throw new MatriculaException(String.format("Não foi possível localizar a matricula atual do aluno ID %s. " +
                       "O Aluno não possui uma Matrícula ano educacional corrente!", idaluno ));
           }
       }else{
           throw new AlunoException(String.format("O aluno de ID %s não foi localizado!", idaluno));
       }

    }
    public ResponseEntity<NotasDto> alterar(Long idnota, Double novaNota) {
       Optional<Notas> nota = repository.findById(idnota);
           if (nota.isEmpty()){
               throw  new NotasException("Nota não localizada!");
           }
           nota.get().setNota(novaNota);
           Notas notaSalva = repository.save(nota.get());
      return ResponseEntity.ok(new NotasDto(notaSalva));
    }


    public ResponseEntity<NotasDto> excluir(Long idnota) {
        Optional<Notas> notas = repository.findById(idnota);
        if (notas.isEmpty()){
            throw new NotasException("Nota não localizada!");
        }else{
            repository.delete(notas.get());
            return ResponseEntity.noContent().build();
        }
    }

}
