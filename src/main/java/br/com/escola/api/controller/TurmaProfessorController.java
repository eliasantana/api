package br.com.escola.api.controller;
import br.com.escola.api.dto.ProfessorDto;
import br.com.escola.api.dto.TurmaProfessorDto;
import br.com.escola.api.services.TurmaProfessorServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmaprofessor")
public class TurmaProfessorController {

    @Autowired
    TurmaProfessorServices services;

    @Operation(description = "Relaciona um professor em uma turma")
    @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping("/adicionar/{idturma}/{idprofessor}")
    public ResponseEntity<TurmaProfessorDto>create(@PathVariable Long idturma, @PathVariable Long idprofessor){
        return services.create(idturma, idprofessor);
    }
    @Operation(description = "Lista todos os profesores da turma informada.")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/listar/{idturma}")
    public ResponseEntity<List<ProfessorDto>>listarProfessor(@PathVariable Long idturma){
        return services.listarProfessor(idturma);
    }
    @Operation(description = "remove um professor de uma turma")
    @ApiResponse(responseCode = "204", description = "Sucesso")
    @PostMapping("/remover/{idturma}/{idprofessor}")
    public ResponseEntity<TurmaProfessorDto> removerProvesorDaTurma(@PathVariable Long idturma, @PathVariable Long idprofessor){
        return services.removerProfessor(idturma, idprofessor);
    }


}
