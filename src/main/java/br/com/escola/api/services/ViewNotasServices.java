package br.com.escola.api.services;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.dto.ViewNotasDto;
import br.com.escola.api.model.ViewNotas;
import br.com.escola.api.repository.ViewNotasRepository;
import br.com.escola.api.services.exceptions.AlunoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViewNotasServices {
    @Autowired
    ViewNotasRepository repository;

    @Autowired
    AlunosServices alunosServices;

    public ResponseEntity<List<ViewNotasDto>> listarNotasAluno(long cdaluno) {
       AlunoDto dto = alunosServices.localizar(cdaluno);
       if (dto==null){
           throw new AlunoException("O aluno informado não foi localizado ou ainda não foi cadastrado!");
       }
       List<ViewNotas> listNotas = repository.getNotasAluno(cdaluno);
       if (listNotas.isEmpty()){
           throw new AlunoException("O aluno informado ainda não possui notas registradas!");
       }
       List<ViewNotasDto> listNotasdto= listNotas.stream().map(v -> new ViewNotasDto( v)).collect(Collectors.toList());
       return ResponseEntity.ok(listNotasdto);
    }
}
