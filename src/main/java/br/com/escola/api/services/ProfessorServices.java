package br.com.escola.api.services;


import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.dto.ProfessorDto;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.Professor;
import br.com.escola.api.repository.AlunoRepository;
import br.com.escola.api.repository.ProfessorRepository;
import br.com.escola.api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorServices {

    @Autowired
    ProfessorRepository repository;

    public ResponseEntity<List<ProfessorDto>> listarTodos() {
       List<Professor> listaProfessores = repository.listartodos();
       List<ProfessorDto> lstProfessorDto= listaProfessores.stream().map(ProfessorDto::new)
               .collect(Collectors.toList());
        return ResponseEntity.ok(lstProfessorDto);
    }

    public ResponseEntity<ProfessorDto> localizar(Long id) {
        return ResponseEntity.ok(new ProfessorDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Professor nâo localizado! " + id))));
    }

    public ResponseEntity<ProfessorDto> delete(Long id) {
        Optional<Professor> profesor = repository.findById(id);
        if (profesor.isPresent()){
            repository.deleteById(id);
        }else{
            throw new NotFoundException(String.format("O professor %s não foi localizado!",id));
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<ProfessorDto> adicionar(ProfessorDto dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        Professor profSalvo = repository.save(professor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profSalvo.getCdProfessor()).toUri();
        return ResponseEntity.created(uri).build();
    }

    public ResponseEntity<ProfessorDto> alterar(ProfessorDto dto, Long id) {
        Professor professor = repository.localizar(id);
        ProfessorDto profDto = new ProfessorDto();
        if (professor!=null){
            Professor novoProfessor = new Professor();
            novoProfessor.setCdProfessor(professor.getCdProfessor());
            novoProfessor.setNome(dto.getNome());
            profDto = new ProfessorDto(repository.save(novoProfessor));
        }else{
            throw new NotFoundException(String.format("Professor ID %s não localizado!"));
        }
        return  ResponseEntity.ok(profDto);
    }
}
