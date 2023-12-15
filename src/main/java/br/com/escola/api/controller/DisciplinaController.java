package br.com.escola.api.controller;

import br.com.escola.api.dto.DisciplinaDto;
import br.com.escola.api.model.Disciplina;
import br.com.escola.api.services.DisciplinaServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaServices services;

    @Operation(description = "Adiciona uma Disciplina")
    @PostMapping("/adicionar")
    public ResponseEntity<DisciplinaDto> create(@RequestBody @Valid DisciplinaDto dto){
        Disciplina disciplina = new Disciplina(dto);
        DisciplinaDto disciplinaDto = services.create(disciplina);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplinaDto.getCdDisciplina()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(description = "Localiza uma disciplina a partir do seu ID")
    @GetMapping("/localizar/{id}")
    public ResponseEntity<DisciplinaDto>localizar(@PathVariable Long id){
      return ResponseEntity.ok().body(services.localizar(id));
    }
    @Operation(description = "Lista todas as disciplinas")
    @GetMapping("/listar")
    public ResponseEntity<List<DisciplinaDto>>localizar(){
        return services.localizarTodas();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisciplinaDto>delete(@PathVariable Long id){
        return services.delete(id);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<DisciplinaDto>put(@PathVariable Long id,@Valid @RequestBody DisciplinaDto disciplinaDto){
        return services.alterar(id, disciplinaDto);
    }
}
