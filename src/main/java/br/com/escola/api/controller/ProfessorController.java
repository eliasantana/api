package br.com.escola.api.controller;

import br.com.escola.api.dto.ProfessorDto;
import br.com.escola.api.services.ProfessorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorServices services;

    @GetMapping("/listar")
    public ResponseEntity<List<ProfessorDto>> listarTodos(){
       return services.listarTodos();
    }

    @GetMapping("/localizar/{id}")
    public ResponseEntity<ProfessorDto>localizar(@PathVariable Long id ){
        return services.localizar(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProfessorDto>delete(@PathVariable Long id ){
        return services.delete(id);
    }
    @PostMapping("/adicionar")
    public ResponseEntity<ProfessorDto>create(@RequestBody ProfessorDto dto){
        return services.adicionar(dto);
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<ProfessorDto>create(@RequestBody ProfessorDto dto, @PathVariable Long id){
        return services.alterar(dto, id);
    }


}
