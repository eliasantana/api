package br.com.escola.api.services;

import br.com.escola.api.dto.DisciplinaDto;
import br.com.escola.api.model.Disciplina;
import br.com.escola.api.repository.DisciplinaRepository;
import br.com.escola.api.services.exceptions.DataIntegrityViolationException;
import br.com.escola.api.services.exceptions.DisciplinaProfessorException;
import br.com.escola.api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaServices {

    @Autowired
    DisciplinaRepository repository;

    public DisciplinaDto create(Disciplina disciplina) {
        disciplina.setDtCadastro(LocalDate.now());

        if(repository.getDisciplina(disciplina.getNome()).isPresent()){
            throw new DataIntegrityViolationException("A disciplina informada já existe!");
        }else {
            return new DisciplinaDto(repository.save(disciplina));
        }

    }

    public DisciplinaDto localizar(Long id) {
       Optional<Disciplina> disciplina = repository.findById(id);
       if (disciplina.isPresent()){
           if (disciplina.get().getSnAtivo().equals("S")){
               return new DisciplinaDto(disciplina.get());
           }else{
               throw new DisciplinaProfessorException("A disciplina informada não está ativa!");
           }

        }else{
            throw new NotFoundException("Disciplina não localizada!");
        }
    }

    public ResponseEntity<List<DisciplinaDto>> localizarTodas() {
        List<Disciplina> disciplinas = repository.localizarTodas();
        return ResponseEntity.ok().body(disciplinas.stream().map(DisciplinaDto::new).collect(Collectors.toList()));
    }

    public ResponseEntity<DisciplinaDto> delete(Long id) {
        Optional<Disciplina> disciplina = repository.findById(id);
        if (disciplina.isPresent()){
            repository.delete(disciplina.get());
        }else{
            throw new NotFoundException("A disciplina informada não existe ou não foi localizada");
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<DisciplinaDto> alterar(Long id, DisciplinaDto dto){
        Disciplina disciplina = new Disciplina();
        if (dto==null){
            throw new NotFoundException("Disciplina Inválida!");
        }
        Optional<Disciplina> disciplinaLocalizada = repository.findById(id);
        if (disciplinaLocalizada.isPresent()){
            disciplinaLocalizada.get().setNome(dto.getNome());
            disciplinaLocalizada.get().setCargaHoraria(dto.getCargaHoraria());
            disciplinaLocalizada.get().setSnAtivo(dto.getSnAtivo());
            disciplina = repository.save(disciplinaLocalizada.get());
        }else{
            throw new NotFoundException("Disciplina nâo localizada!");
        }
        return ResponseEntity.ok().body(new DisciplinaDto(disciplina));
    }

    public ResponseEntity<DisciplinaDto> ativaDesativaDisciplina(Long idDisciplina) {
      Optional<Disciplina> disciplinaLocalizada = repository.findById(idDisciplina);
      if (disciplinaLocalizada.isEmpty()) throw new NotFoundException("A disciplina informada não foi localizada!");
      if (disciplinaLocalizada.get().getSnAtivo().equals("S")){
          disciplinaLocalizada.get().setSnAtivo("N");
      }else{
          disciplinaLocalizada.get().setSnAtivo("S");
      }
      return ResponseEntity.ok(new DisciplinaDto(repository.save(disciplinaLocalizada.get())));
    }
}
