package br.com.escola.api.controller;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.services.AlunosServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.w3c.dom.stylesheets.LinkStyle;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunosServices services;

    @PostMapping
    @Operation(description = "Adiciona um aluno Aluno")
    public ResponseEntity<AlunoDto> create(@RequestBody @Valid AlunoDto dto){
        AlunoDto alunoDto= services.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoDto.getCdAluno()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/localizar/{id}")
    @Operation(description = "Localizar um Aluno pelo seu código.")
    public ResponseEntity<AlunoDto> localizar(@RequestBody @Valid @PathVariable(name = "id") Long id){
        AlunoDto alunoDto= services.localizar(id);
        return ResponseEntity.ok().body(alunoDto);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(description = "Deleta um Aluno.")
    public ResponseEntity<AlunoDto> delete(@RequestBody @Valid @PathVariable(name = "id") Long id){
        return services.delete(id);
    }

    @PutMapping("/alterar/{id}")
    @Operation(description = "Altera um aluno")
    public ResponseEntity<AlunoDto> put(@PathVariable Long id, @Valid @RequestBody AlunoDto alunoDto){
        AlunoDto alunoAlterado = services.update(alunoDto, id);
        return ResponseEntity.ok(alunoAlterado);
    }

    @GetMapping("/listar")
    @Operation(description = "Lista todos os Alunos")
    public  ResponseEntity<List<AlunoDto>> listar(){
       List <AlunoDto> alunos = services.ListartTodos();
       return ResponseEntity.ok(alunos);
    }
    @GetMapping("/matriculados")
    public ResponseEntity<List<AlunoDto>> alunosMatriculados(){
        return services.alunosMatriculados();
    }

}
