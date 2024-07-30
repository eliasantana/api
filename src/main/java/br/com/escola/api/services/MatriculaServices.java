package br.com.escola.api.services;

import br.com.escola.api.model.Aluno;
import br.com.escola.api.model.CadEscola;
import br.com.escola.api.model.Funcionario;
import br.com.escola.api.model.Matricula;
import br.com.escola.api.dto.MatriculaDto;
import br.com.escola.api.repository.AlunoRepository;
import br.com.escola.api.repository.FuncionarioRepository;
import br.com.escola.api.repository.MatriculaRepository;
import br.com.escola.api.services.exceptions.CadEscolaException;
import br.com.escola.api.services.exceptions.MatriculaException;
import br.com.escola.api.services.exceptions.MatriculaExistenteException;
import br.com.escola.api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.LocalDate.now;

@Service
public class MatriculaServices {
    @Autowired
    MatriculaRepository repository;
    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    CadEscolaServices cadEscolaServices;

    public ResponseEntity<MatriculaDto> create(Long idaluno, Long idfuncionario, Long idescola) {
      Optional<Aluno> alunoLocalizado = alunoRepository.findById(idaluno);
      Aluno aluno = alunoLocalizado.get();
      Optional<CadEscola> escolaLocalizada = cadEscolaServices.localizar(idescola);
      if (escolaLocalizada.isEmpty()){
          throw new CadEscolaException("Escola não localizada!");
      }
      aluno.setEscola(escolaLocalizada.get());
      alunoRepository.save(aluno);
      Optional<Funcionario> funcionarioLocalizado = funcionarioRepository.findById(idfuncionario);
      String tpOperacao="M"; //M = Matricula
      validaAlunoLocalizado(alunoLocalizado, funcionarioLocalizado,tpOperacao);

      Matricula matricula = new Matricula();
      matricula.setDtMatricula(now());
      matricula.setFuncionario(funcionarioLocalizado.get());
      matricula.setAluno(alunoLocalizado.get());
      matricula.setStatus(tpOperacao);
      String localizador = alunoLocalizado.get().getCdAluno().toString()
                                                .concat(String.valueOf(now().getMonthValue())
                                                .concat(String.valueOf(now().getYear())).concat(funcionarioLocalizado.get().getCdFuncionario().toString()));
      matricula.setLocalizador(localizador);
      Matricula matSalva = repository.save(matricula);
      alunoRepository.save(alunoLocalizado.get());
        //return ResponseEntity.ok().body(new MatriculaDto(matSalva));
      return ResponseEntity.noContent().build();


    }

    public ResponseEntity<MatriculaDto> cancelar(String localizador) {
       Optional<Matricula> matLocalizada = repository.getMatriculaAtual(localizador);
       if(matLocalizada.isEmpty()){
           throw new NotFoundException("A Matricula informada não foi localizada!");
       }else{
           matLocalizada.get().setStatus("C");
           Aluno aluno = matLocalizada.get().getAluno();
           aluno.setSnAtivo("N");
           alunoRepository.save(aluno);
       }
       return ResponseEntity.ok().body(new MatriculaDto(repository.save(matLocalizada.get())));
    }

    public ResponseEntity<MatriculaDto> renovar(Long idaluno, Long idfuncionario) {
        String tpOperacao="R";

        LocalDate dataRenovacao = LocalDate.now();
        int mes = dataRenovacao.getMonthValue();

        if (mes==12 || mes==1){
            dataRenovacao = LocalDate.now().plusMonths(1);
        }else{
            throw new IllegalArgumentException("Não é possível realizar renovação fora do período. Consulte o Administrador");
        }
        Optional<Aluno> alunoLocalizado = alunoRepository.findById(idaluno);
        Optional<Funcionario> funcionarioLocalizado = funcionarioRepository.findById(idfuncionario);

        validaAlunoLocalizado(alunoLocalizado, funcionarioLocalizado,tpOperacao);

        Matricula matricula = new Matricula();
        matricula.setDtMatricula(dataRenovacao);
        matricula.setFuncionario(funcionarioLocalizado.get());
        matricula.setAluno(alunoLocalizado.get());
        matricula.setStatus("M");

        String localizador = alunoLocalizado.get().getCdAluno().toString()
                .concat(String.valueOf(dataRenovacao.getMonthValue())
                        .concat(String.valueOf(dataRenovacao.getYear())).concat(funcionarioLocalizado.get().getCdFuncionario().toString()));
        matricula.setLocalizador(localizador);
        Matricula matSalva = repository.save(matricula);

        return ResponseEntity.ok().body(new MatriculaDto(matSalva));
    }

    private void validaAlunoLocalizado(Optional<Aluno> alunoLocalizado, Optional<Funcionario> funcionarioLocalizado, String tpOperacao) {

        if (alunoLocalizado.isEmpty()){
            throw new NotFoundException("O aluno informado não foi localizado!");
        }else{
            Optional<Matricula> matLocalizada = repository.getMatriculaAtual(alunoLocalizado.get().getCdAluno());
            if (matLocalizada.isPresent()&&tpOperacao.equals("M")){
                throw new MatriculaExistenteException(String.format("Não é possível matricular o aluno informado. Ele já possui uma matricula para o ano Corrente! Mattícula->:" + matLocalizada.get().getLocalizador()));
            }
        }
        if (funcionarioLocalizado.isEmpty()){
            throw new NotFoundException("O Funcionário informado não foi localizado!");
        }
    }

    public ResponseEntity<MatriculaDto> getMatricula(String localizador) {
       return ResponseEntity.ok().body(new MatriculaDto( repository.getMatricula(localizador).orElseThrow(()->new NotFoundException("Matrícula não localizada!"))));
    }
    public ResponseEntity<MatriculaDto> getMatricula(Long cdaluno) {
       Optional<Matricula> matLocalizada = repository.getMatriculaAtual(cdaluno);
       if (matLocalizada.isEmpty()){
           throw new MatriculaException("Matrícula do Aluno nâo localizada!");
       }else{
           return ResponseEntity.ok(new MatriculaDto(matLocalizada.get()));
       }
    }

    public Matricula getMatriculaAluno(Long cdaluno) {
       Optional<Matricula> matriculaLocalizada = repository.getMatriculaAluno(cdaluno);
       if(matriculaLocalizada.isEmpty()){
           throw new MatriculaException("Matrícula do Aluno nâo localizada!");
       }else{
           return matriculaLocalizada.get();
       }
    }
}
