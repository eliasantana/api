package br.com.escola.api.services;

import br.com.escola.api.dto.CargaHorariaDto;
import br.com.escola.api.dto.DisciplinaDto;
import br.com.escola.api.dto.DisciplinaProfessorDto;
import br.com.escola.api.dto.ProfessorDto;
import br.com.escola.api.model.Disciplina;
import br.com.escola.api.model.DisciplinaProfessor;
import br.com.escola.api.model.Professor;
import br.com.escola.api.model.TurmaProfessor;
import br.com.escola.api.repository.DisciplinaProfessorRepository;
import br.com.escola.api.services.exceptions.DisciplinaProfessorException;
import br.com.escola.api.services.exceptions.NotFoundException;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaProfessorServices {

    @Autowired
    DisciplinaProfessorRepository repository;

    @Autowired
    ProfessorServices professorServices;

    @Autowired
    DisciplinaServices disciplinaServices;


    public ResponseEntity<DisciplinaProfessorDto> adicionar(Long idDisciplina, Long idProfessor) {
        DisciplinaDto disciplinaDto = disciplinaServices.localizar(idDisciplina);
        Optional<Professor> professor = professorServices.getProfessor(idProfessor);
        if (disciplinaDto==null){
            throw new NotFoundException(String.format("A disciplina de ID %s  não foi localizada ou não existe!",idDisciplina));
        }
        if (professor.isEmpty()){
            throw new NotFoundException(String.format("O professor de ID %s não foi localizado ou não existe!",idProfessor));
        }
        Optional<DisciplinaProfessor> disciplinaProfessor=repository.getDisciplinaProfessor(idDisciplina, idProfessor);

        if(disciplinaProfessor.isEmpty()){
            DisciplinaProfessor dp = new DisciplinaProfessor();
            dp.setDisciplina(new Disciplina(disciplinaDto));
            dp.setProfessor(professor.get());
            DisciplinaProfessor disciplinaProfessorSalva = repository.save(dp);
            return ResponseEntity.ok(new DisciplinaProfessorDto(disciplinaProfessorSalva));
        }else {
            throw new DisciplinaProfessorException(String.format(String.format("O professor  %s já leciona a Disciplina %s informe uma nova!. ",professor.get().getNome(),disciplinaDto.getNome())));
        }

   }

    public ResponseEntity<List<DisciplinaDto>> getListaTurmaPorProfessor(Long idProfessor) {
       List<DisciplinaProfessor> disciplinaPorProfessorList = repository.getDisciplinaPorProfessor(idProfessor);

       if(disciplinaPorProfessorList.isEmpty()){
           throw new DisciplinaProfessorException("O professor informado nâo leciona em nenhuma disciplina cadastrada! Favor Cadastrar uma disciplina!");
       }

       List<DisciplinaDto> disciplinaDtos = new ArrayList<>();
        for (DisciplinaProfessor dp : disciplinaPorProfessorList){
            disciplinaDtos.add(new DisciplinaDto(dp.getDisciplina()));
        }
        return ResponseEntity.ok(disciplinaDtos);
    }

    public ResponseEntity<CargaHorariaDto> getCargaHoriaProfessor(Long idProfessor) {
       Optional<Professor> professorLocalizado = professorServices.getProfessor(idProfessor);
       List<DisciplinaProfessor> disciplinaProfessorList = repository.getDisciplinaPorProfessor(idProfessor);
       BigDecimal carga = BigDecimal.ZERO;
       CargaHorariaDto cargaHoraria = new CargaHorariaDto();
       cargaHoraria.setProfessor(new ProfessorDto(professorLocalizado.get()));
       if (disciplinaProfessorList.isEmpty()){
           cargaHoraria.setCargaHorariaTotal(carga);
       }else{
           for (DisciplinaProfessor dp : disciplinaProfessorList){
               carga = carga.add(BigDecimal.valueOf(dp.getDisciplina().getCargaHoraria()));
           }
           cargaHoraria.setCargaHorariaTotal(carga);
       }
       return ResponseEntity.ok(cargaHoraria);
    }
}
