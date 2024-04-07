package br.com.escola.api.controller;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.dto.CadEscolaDto;
import br.com.escola.api.model.CadEscola;
import br.com.escola.api.services.CadEscolaServices;
import br.com.escola.api.services.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cadastro")
public class CadEscolaController {
    @Autowired
    CadEscolaServices services;
    @Operation(description = "Cadastra uma escola")
    @PostMapping("/adicionar")
    public ResponseEntity<CadEscolaDto> adicionar (@RequestBody @Valid CadEscolaDto dto){
        System.out.println(dto.toString());
        return services.createCadEscola(dto);
    }
    @Operation(description = "Lista as escola cadastradas")
    @GetMapping("/listar")
    public ResponseEntity<List<CadEscolaDto>> listar (){
        return services.listar();
    }

    @Operation(description = "Localiza a escola informada")
    @GetMapping("/localizar/{id}")
    public ResponseEntity<CadEscolaDto> localizar ( @PathVariable Long id){
       Optional<CadEscola> cadastroLocalizdo = services.localizar(id);
        if (cadastroLocalizdo.isPresent()){
            return ResponseEntity.ok(new CadEscolaDto(cadastroLocalizdo.get()));
        }else{
            throw new NotFoundException("Cadastro não localizado!");
        }

    }

    @Operation(description = "Altera uma escola")
    @PutMapping("/alterar/{id}")
    public ResponseEntity<CadEscolaDto>alterar(@RequestBody CadEscolaDto dto, @PathVariable Long id){
        return services.alterar(id, dto);
    }

    @Operation(description = "Lista os alunos da Escola informada")
    @GetMapping("/lista-de-alunos/{idescola}")
    public ResponseEntity<List<AlunoDto>>listarAlunosEscola(@PathVariable Long idescola){
        return services.listarAlunosEscola(idescola);
    }

    @Operation(description = "Transfere um aluno da escola de origem para a escola de Destino")
    @PostMapping("/transferir/{cdaluno}/{cddestino}")
    public ResponseEntity<AlunoDto>transferir(@PathVariable Long cdaluno, @PathVariable Long cddestino ){
        return services.transferirAluno(cdaluno, cddestino);
    }
}
