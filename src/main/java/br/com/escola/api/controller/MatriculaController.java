package br.com.escola.api.controller;

import br.com.escola.api.dto.MatriculaDto;
import br.com.escola.api.model.Matricula;
import br.com.escola.api.services.MatriculaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    MatriculaServices services;
    @Operation(description = "Matricula um aluno. Informando o ID do aluno e o ID do funcionário")
    @ApiResponse(responseCode ="200", description = "Matrícula Realizada com sucesso!")
    @PutMapping("/matricular/{idaluno}/{idfuncionario}")
    public ResponseEntity<MatriculaDto> create(@PathVariable Long idaluno, @PathVariable Long idfuncionario){
        return services.create(idaluno, idfuncionario);
    }
    @Operation(description = "Cancela uma matrícula a partir do Localizador")
    @PostMapping("/cancelar/{localizador}")
    public ResponseEntity<MatriculaDto>cancelar(@PathVariable String localizador){
      return  services.cancelar(localizador);
    }
    @Operation(description = "Renova uma matrícula. O mês deve ser dezembro ou janeiro e o aluno não pode possuir matrícula ativa.")
    @PostMapping("/renovar/{idaluno}/{idfuncionario}")
    public ResponseEntity<MatriculaDto> renovar(@PathVariable Long idaluno, @PathVariable Long idfuncionario){
        return services.renovar(idaluno, idfuncionario);
    }
    @Operation(description = "Localiza uma matrícula por meio do localizador!")
    @GetMapping("/localizar/{localizador}")
    public ResponseEntity<MatriculaDto> getMatricula(@PathVariable String localizador){
        return  services.getMatricula(localizador);
    }
}
