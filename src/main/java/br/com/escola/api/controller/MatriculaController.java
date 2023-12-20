package br.com.escola.api.controller;

import br.com.escola.api.dto.MatriculaDto;
import br.com.escola.api.model.Matricula;
import br.com.escola.api.services.MatriculaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    MatriculaServices services;

    @PutMapping("/matricular/{idaluno}/{idfuncionario}")
    public ResponseEntity<MatriculaDto> create(@PathVariable Long idaluno, @PathVariable Long idfuncionario){
        return services.create(idaluno, idfuncionario);
    }

    @PostMapping("/cancelar/{localizador}")
    public ResponseEntity<MatriculaDto>cancelar(@PathVariable String localizador){
      return  services.cancelar(localizador);
    }

    @PostMapping("/renovar/{idaluno}/{idfuncionario}")
    public ResponseEntity<MatriculaDto> renovar(@PathVariable Long idaluno, @PathVariable Long idfuncionario){
        return services.renovar(idaluno, idfuncionario);
    }
   @GetMapping("/localizar/{localizador}")
    public ResponseEntity<MatriculaDto> getMatricula(@PathVariable String localizador){
        return  services.getMatricula(localizador);
    }
}
