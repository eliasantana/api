package br.com.escola.api.services;

import br.com.escola.api.dto.AlunoDto;
import br.com.escola.api.dto.AlunoTurmaDto;
import br.com.escola.api.dto.TurmaDto;
import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.AlunoTurma;
import br.com.escola.api.model.Turma;
import br.com.escola.api.repository.AlunoTurmaRepository;
import br.com.escola.api.services.exceptions.AlunoTurmaException;
import br.com.escola.api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoTurmaServices {
    @Autowired
    AlunoTurmaRepository repository;
    @Autowired
    AlunosServices alunosServices;
    @Autowired
    TurmaServices turmaServices;
    @Autowired
    MatriculaServices matriculaServices;

    public ResponseEntity<AlunoTurmaDto> adicionar(long idaluno, long idturma) {
        if (matriculaServices.getMatricula(idaluno).isEmpty()) throw new NotFoundException("O aluno não pode ser incluído nesta turma pois ainda não foi matriculado!, Matricule o aluno para continuar!");
        TurmaDto turmaDto = turmaServices.localizarTurma(idturma);
        AlunoDto alunoDto =  alunosServices.localizar(idaluno);
        Optional<AlunoTurma> existe = repository.existe(idaluno, idturma);
        if (existe.isEmpty()){
            if (turmaDto.getCapacidade() == 0) {
                throw new NotFoundException("A turma informada não possui vagas disponível");
            }
            if (alunoDto == null){
                throw new NotFoundException("Aluno é obrigatório");
            }
            Turma t = new Turma(turmaDto);
            t.setcapacidade(t.getcapacidade()-1);
            Aluno a = new Aluno(alunoDto);
            AlunoTurma alunoTurma = new AlunoTurma();
            alunoTurma.setAluno(a);
            alunoTurma.setTurma(t);
            AlunoTurma alunoTurmaSalvo = repository.save(alunoTurma);
            turmaServices.turmaRepository.save(t);
            return new ResponseEntity<>(new AlunoTurmaDto(alunoTurmaSalvo), HttpStatus.CREATED);
        }else{
            throw new AlunoTurmaException(String.format("O aluno %s, já encontra-se na turma %s ",alunoDto.getNome(), turmaDto.getDsTurma()));
        }
    }


    public ResponseEntity<List<AlunoTurmaDto>> listar() {
        List<AlunoTurma> alunoTurmaList = repository.listar();
        List<AlunoTurmaDto> alunoTurmaDtoList = alunoTurmaList.stream().toList()
                .stream().map(alunoTurma -> new AlunoTurmaDto(alunoTurma))
                .collect(Collectors.toList());
        return ResponseEntity.ok(alunoTurmaDtoList);
    }

    public Turma localizarTurmaAluno(Long idaluno) {
        Optional<AlunoTurma> alunoTurma = repository.getAlunoTurma(idaluno);
        if (alunoTurma.isPresent()){
            return alunoTurma.get().getTurma();
        }else {
            throw new NotFoundException("O aluno informado não possui ou não está matriculado em uma turma!");
        }

    }
    public AlunoTurma getTurma(Long idaluno) {
        Optional<AlunoTurma> alunoTurma = repository.getAlunoTurma(idaluno);
        if (alunoTurma.isPresent()){
            return alunoTurma.get();
        }else {
            throw new NotFoundException("O aluno informado não possui ou não está matriculado em uma turma!");
        }

    }

    public ResponseEntity<AlunoTurmaDto> transferir(Long idaluno, Long idturma) {
        TurmaDto turmaDestinoDto = turmaServices.localizarTurma(idturma);
        AlunoDto alunoDto = alunosServices.localizar(idaluno);
        if (alunoDto==null){
            throw new NotFoundException(String.format("O aluno de ID %s não foi localizado!",idaluno));
        }
        if (turmaDestinoDto==null){
            throw new NotFoundException("A turma informada não foi localizada");
        }else if(turmaDestinoDto.getCapacidade()==0){
            throw new NotFoundException(String.format("A turma %s não possui vagas suficiente!",turmaDestinoDto.getDsTurma()) );
        }

        AlunoTurma alunoTurma = getTurma(idaluno);
        Turma turmaAtual = alunoTurma.getTurma();
        Turma turmaDestino = new Turma(turmaDestinoDto);
        if (turmaAtual.getCdTurma().equals(turmaDestino.getCdTurma())){
            throw new NotFoundException(String.format("A turma de Destino não pode ser igual a turma atual do aluno! ",turmaDestino.getDsTurma()) );
        }else{
            alunoTurma.setTurma(turmaDestino);
            repository.save(alunoTurma);
            turmaServices.salvar(turmaServices.incrementaVaga(turmaAtual));
            turmaServices.salvar(turmaServices.decremanta(turmaDestino));
            return new ResponseEntity<>(new AlunoTurmaDto(repository.save(alunoTurma)),HttpStatus.CREATED);
        }

    }

    public ResponseEntity<List<AlunoTurmaDto>> listarTurma(Long cdturma) {
       List<AlunoTurma> alunoTurma = repository.listarTurma(cdturma);
       if(!alunoTurma.isEmpty()){
           List<AlunoTurmaDto> alunoTurmaDto = alunoTurma.stream().map(a -> new AlunoTurmaDto(a))
                   .collect(Collectors.toList());
           return ResponseEntity.ok(alunoTurmaDto);
       }else{
           throw new NotFoundException(String.format("Turma de ID %s não foi loacalizada!",cdturma) );
       }

    }
}
