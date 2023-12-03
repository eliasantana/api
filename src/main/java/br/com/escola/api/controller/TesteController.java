package br.com.escola.api.controller;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class TesteController {
    @GetMapping("/teste")
    public void teste(){

        Aluno aluno = new Aluno();
        aluno.setCpf(81776144449L);
        aluno.setNome("Carlos");
        aluno.setDtCadastro(LocalDate.now());
        aluno.setSnAtivo("S");

        Aluno aluno2 = new Aluno();
        aluno2.setCpf(81776144449L);
        aluno2.setNome("Judite");
        aluno2.setDtCadastro(LocalDate.now());
        aluno2.setSnAtivo("S");

        List<AlunoDto> alunos = new ArrayList<>();
        alunos.add(new AlunoDto(aluno));
        alunos.add(new AlunoDto(aluno2));

        for (AlunoDto dto:alunos) {
            System.out.println(dto.toString());
        }


    }

}
