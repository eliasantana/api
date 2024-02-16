package br.com.escola.api.controller;

import br.com.escola.api.dto.AlunoTurmaDto;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.services.AlunoTurmaServices;
import br.com.escola.api.services.AlunosServices;
import br.com.escola.api.services.TurmaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/alunoturma")
public class AlunoTurmaController {
    @Autowired
    AlunoTurmaServices services;
    @Autowired
    TurmaServices turmaServices;
    @Autowired
    AlunosServices alunosServices;

    @Operation(description = "Adiciona um aluno a uma turma")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @PostMapping("/adicionar/{idaluno}/{idturma}")
    public ResponseEntity<AlunoTurmaDto>adicionar(@PathVariable long idaluno, @PathVariable long idturma){
        return services.adicionar(idaluno, idturma);
    }


    @GetMapping("/alterar/{idAlunoTurma}")
    public ResponseEntity<AlunoTurmaDto>alterar(@PathVariable Long idAlunoturma){
        return null;
    }

    @Operation(description = "Lista todos os alunos")
    @GetMapping("/listar")
    public ResponseEntity<List<AlunoTurmaDto>>listar(){
        return services.listar();
    }

    @Operation(description = "Lista todos da turma informada")
    @GetMapping("/listar/{cdturma}")
    public ResponseEntity<List<AlunoTurmaDto>>listar(@PathVariable long cdturma) {
        return services.listarTurma(cdturma);
    }
    @Operation(description = "Transfere um aluno de uma turma para outra")
    @PostMapping("/transferir/{idaluno}/{idturma}")
    public ResponseEntity<AlunoTurmaDto>transferir(@PathVariable Long idaluno, @PathVariable Long idturma){
         return services.transferir(idaluno,idturma);
    }


}
