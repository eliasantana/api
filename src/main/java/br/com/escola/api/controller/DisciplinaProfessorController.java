package br.com.escola.api.controller;

import br.com.escola.api.dto.CargaHorariaDto;
import br.com.escola.api.dto.DisciplinaDto;
import br.com.escola.api.dto.DisciplinaProfessorDto;
import br.com.escola.api.services.DisciplinaProfessorServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinaprofessor")
public class DisciplinaProfessorController {
    @Autowired
    DisciplinaProfessorServices services;
    @Operation(description = "Associa um Professor a uma Disciplina")
    @PostMapping("/adicionar/{iddisciplina}/{idprofessor}")
    public ResponseEntity<DisciplinaProfessorDto>adicionar(@PathVariable (name = "iddisciplina") Long iddisciplina,
                                                           @PathVariable (name = "idprofessor") Long idprofessor){
        return services.adicionar(iddisciplina, idprofessor);

    }
    @Operation(description = "Lista todas as displinas do professor informado")
    @GetMapping("/listar/{idProfessor}")
    public ResponseEntity<List<DisciplinaDto>>listarTurmaPorProfessor(@PathVariable Long idProfessor){
       return services.getListaTurmaPorProfessor(idProfessor);
    }
    @Operation(description = "Retorna a Carga Horária de um professor baseada no Cadastro Professor Disciplina")
    @GetMapping("/carga/{idProfessor}")
    public ResponseEntity<CargaHorariaDto> getCargaHoraria(@PathVariable Long idProfessor){
        return services.getCargaHoriaProfessor(idProfessor);
    }



}
