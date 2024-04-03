package br.com.escola.api.controller;

import br.com.escola.api.dto.NotasDto;
import br.com.escola.api.dto.ViewNotasDto;
import br.com.escola.api.repository.ViewNotasRepository;
import br.com.escola.api.services.NotasServices;
import br.com.escola.api.services.ViewNotasServices;
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

    @PostMapping("/adicionar/{idaluno}/{iddisciplina}/{nota}")
    public ResponseEntity<NotasDto> adicionarNotas(@PathVariable  Long idaluno, @PathVariable Long iddisciplina, @PathVariable Double nota){
        return services.adicionar(idaluno, iddisciplina,nota);
    }

    @PutMapping("/alterar/{idnota}/{novanota}")
    public ResponseEntity<NotasDto> adicionarNotas(@PathVariable  Long idnota, @PathVariable Double novanota){
        return services.alterar(idnota,novanota);
    }

    @DeleteMapping("/excluir/{idnota}")
    public ResponseEntity<NotasDto> excluir(@PathVariable  Long idnota){
        return services.excluir(idnota);
    }

    @GetMapping("/listar/{cdaluno}")
    public ResponseEntity<List<ViewNotasDto>> listarNotasAluno(@PathVariable long cdaluno){
        return  viewNotasServices.listarNotasAluno(cdaluno);
    }

}
