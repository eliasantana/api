package br.com.escola.api.services;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.dto.CadEscolaDto;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.CadEscola;
import br.com.escola.api.model.ViewNotas;
import br.com.escola.api.repository.AlunoRepository;
import br.com.escola.api.repository.CadEscolaRepository;
import br.com.escola.api.services.exceptions.AlunoException;
import br.com.escola.api.services.exceptions.NotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.ListView;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CadEscolaServices {
    @Autowired
    CadEscolaRepository repository;
    @Autowired
    AlunosServices alunosServices;
    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    ViewNotasServices viewNotasServices;

    public ResponseEntity<CadEscolaDto> createCadEscola(CadEscolaDto dto) {
        CadEscola cadastro = new CadEscola(dto);
        CadEscola cadEscola = repository.save(cadastro);
        CadEscolaDto cadEscolaDto = new CadEscolaDto(cadEscola);
        return new ResponseEntity<>(cadEscolaDto, HttpStatus.CREATED);
    }

    public ResponseEntity<List<CadEscolaDto>> listar() {
        List<CadEscola> listCadEscola = repository.listar();
        List<CadEscolaDto> listDto = listCadEscola.stream()
                .map(cadEscola -> new CadEscolaDto(cadEscola))
                .collect(Collectors.toList());
      return  ResponseEntity.ok(listDto);
    }

    public Optional<CadEscola> localizar(Long id) {
        return repository.findById(id);
    }

    public ResponseEntity<CadEscolaDto> alterar(Long id, CadEscolaDto dto) {
        Optional<CadEscola> cadEscola = localizar(id);
        if (cadEscola.isPresent()){
            dto.setCdEscola(cadEscola.get().getCdEscola());
            CadEscola cadastroSalvo = repository.save(new CadEscola(dto));
            return ResponseEntity.ok(new CadEscolaDto(cadastroSalvo));
        }else{
           throw new NotFoundException("Cadastro não localizado!");
        }
    }

    public ResponseEntity<List<AlunoDto>> listarAlunosEscola(Long idescola) {
        if (repository.findById(idescola).isEmpty()){
            throw new NotFoundException("A escola informada não foi localizada!");
        }
        List<Aluno> listaDeAlunos = alunosServices.listarAlunos(idescola);
        if (listaDeAlunos.isEmpty()){
            throw new AlunoException("A escola informada não possui aluno matriculado!");
        }
        List<AlunoDto> dto = listaDeAlunos.stream().map(AlunoDto::new).collect(Collectors.toList());
        return  ResponseEntity.ok(dto);
    }

    public ResponseEntity<AlunoDto> transferirAluno(Long cdaluno, Long cdDestino) {
       AlunoDto alunoDto = alunosServices.localizar(cdaluno);
       if (alunoDto==null){
           throw new AlunoException("O aluno informado não foi localizado!");
       }else{
           Optional<CadEscola> escolaDestino = repository.findById(cdDestino);
           if(escolaDestino.isEmpty()){
               throw new AlunoException("A escola informada não  foi localizada!");
           }
           Aluno aluno = new Aluno(alunoDto);
           aluno.setEscola(escolaDestino.get());
           Aluno alunoSalvo = alunoRepository.save(aluno);
           return ResponseEntity.ok(new AlunoDto(alunoSalvo));
       }


    }
}
