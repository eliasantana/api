package br.com.escola.api.controller;

import br.com.escola.api.dto.NotasDto;
import br.com.escola.api.dto.ViewNotasDto;
import br.com.escola.api.repository.ViewNotasRepository;
import br.com.escola.api.services.NotasServices;
import br.com.escola.api.services.ViewNotasServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    NotasServices services;

    @Autowired
    ViewNotasServices viewNotasServices;
    @Operation(description = "Adiciona uma nota para uma aluno em uma disciplina")
    @PostMapping("/adicionar/{idaluno}/{iddisciplina}/{nota}/{tiponota}")
    public ResponseEntity<NotasDto> adicionarNotas(@PathVariable  Long idaluno, @PathVariable Long iddisciplina, @PathVariable Double nota, @PathVariable int tiponota){
        return services.adicionar(idaluno, iddisciplina,nota, tiponota);
    }
    @Operation(description = "Altera a nota de uma aluno")
    @PutMapping("/alterar/{idnota}/{novanota}")
    public ResponseEntity<NotasDto> adicionarNotas(@PathVariable  Long idnota, @PathVariable Double novanota){
        return services.alterar(idnota,novanota);
    }
    @Operation(description = "Exclui uma nota")
    @DeleteMapping("/excluir/{idnota}")
    public ResponseEntity<NotasDto> excluir(@PathVariable  Long idnota){
        return services.excluir(idnota);
    }

    @Operation(description = "Listar notas do aluno informado")
    @GetMapping("/listar/{cdaluno}")
    public ResponseEntity<List<ViewNotasDto>> listarNotasAluno(@PathVariable long cdaluno){
        return  viewNotasServices.listarNotasAluno(cdaluno);
    }

}
