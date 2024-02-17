package br.com.escola.api.services;

import br.com.escola.api.dto.ProfessorDto;
import br.com.escola.api.dto.TurmaDto;
import br.com.escola.api.dto.TurmaProfessorDto;
import br.com.escola.api.model.Professor;
import br.com.escola.api.model.Turma;
import br.com.escola.api.model.TurmaProfessor;
import br.com.escola.api.repository.TurmaProfessorRepository;
import br.com.escola.api.services.exceptions.NotFoundException;
import br.com.escola.api.services.exceptions.TurmaProfessorException;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmaProfessorServices {
    @Autowired
    TurmaProfessorRepository repository;
    @Autowired
    TurmaServices turmaServices;

    @Autowired
    ProfessorServices professorServices;

    public ResponseEntity<TurmaProfessorDto> create(Long idturma, Long idprofesor) {
        TurmaDto turmaDto = turmaServices.localizarTurma(idturma);
        Optional<Professor> professorLocaliado = professorServices.getProfessor(idprofesor);
        Optional<TurmaProfessor> turmaProfessor = repository.existTurmaProfessor(idturma, idprofesor);
        TurmaProfessor tp = new TurmaProfessor();
        TurmaProfessor turmaProfessorSalva = null;
        if (turmaProfessor.isEmpty()) {
            tp.setTurma(new Turma(turmaDto));
            tp.setProfessor(professorLocaliado.get());
            turmaProfessorSalva = repository.save(tp);
            return new ResponseEntity<>(new TurmaProfessorDto(turmaProfessorSalva), HttpStatus.CREATED);
        }else{
            throw new TurmaProfessorException(String.format("O professor %s, já encontra-se lotado(a) na turma informada. " +
                    " Porfavor informar outra turma. ",professorLocaliado.get().getNome()));
        }

    }

    public ResponseEntity<List<ProfessorDto>> listarProfessor(Long idturma) {
     List<TurmaProfessor> turmaProfessorList = repository.listarProfessor(idturma);
     List<ProfessorDto> dto = new ArrayList<>();
        for (TurmaProfessor turma : turmaProfessorList){
            dto.add(new ProfessorDto(turma.getProfessor()));
        }
     return ResponseEntity.ok(dto);
    }

    public ResponseEntity<TurmaProfessorDto> removerProfessor(Long idturma, Long idprofessor) {
       Optional<TurmaProfessor> turmaProfessor = repository.existTurmaProfessor(idturma, idprofessor);
       if (turmaProfessor.isPresent()){
          repository.delete(turmaProfessor.get());
          return ResponseEntity.noContent().build();
       }else{
           throw new TurmaProfessorException(String.format("O profesor ID %s não encontra-se lotado na Turma ID %s por isso não foi localizado!", idprofessor, idturma));
       }
    }
}
