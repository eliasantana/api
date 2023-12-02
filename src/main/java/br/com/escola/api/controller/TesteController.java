package br.com.escola.api.controller;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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

        System.out.println("Dados convertidos para Aluno Dto");
        AlunoDto dto = aluno.convertToDto();
        System.out.println(dto.toString());

        System.out.println("Convertendo de Dto para Aluno");
        Aluno alunoConvertido = dto.convertToAluno();
        System.out.println(alunoConvertido.toString());


    }

}
