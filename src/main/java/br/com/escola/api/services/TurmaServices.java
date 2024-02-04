package br.com.escola.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.api.dto.TurmaDto;
import br.com.escola.api.model.Turma;
import br.com.escola.api.repository.TurmaRepository;
import br.com.escola.api.services.exceptions.NotFoundException;

@Service
public class TurmaServices {
	
	@Autowired
	TurmaRepository turmaRepository;
	private List<TurmaDto> listTurmaDto;
	
	public TurmaServices() {
	}
	
	public TurmaDto  localizarTurma(Long cdTurma) {
		Turma turma =  this.turmaRepository.localizarTurma(cdTurma);
		if (turma == null ) {
			throw new NotFoundException ("Não existe uma turma com o ideitificador especificado: " + cdTurma.toString() );
		}
		
		return new TurmaDto(turma);	
	}
	
	public List<TurmaDto> listaDeTurmas() {
		List<Turma> turmas = this.turmaRepository.listaDeTurmas();
		
		List<TurmaDto> listTurmaDto = turmas.stream()
	              .map(turma -> new TurmaDto(turma))
	              .collect(Collectors.toList());
	      return listTurmaDto;
	}
	
	public TurmaDto cadastrarTurma(TurmaDto turmaDto) {
		Turma turma = new Turma(turmaDto);
		Turma turmaLocalizada = turmaRepository.exists(turma.getDsTurma(), turma.getLocal());
		if (turmaLocalizada == null){
			turma.setDsTurma(turma.getDsTurma().replaceAll(" ",""));
			turma.setLocal(turma.getLocal().replaceAll(" ", ""));
			return new TurmaDto(this.turmaRepository.save(turma));
		}else{
			throw new NotFoundException("A turma informada já existe no local informado! -> Turma: " + turmaDto.getDsTurma() + " Local: "+turmaDto.getLocal());
		}
	}
	
	public void deletaTurma(Long cdTurma) {
		Optional<Turma> turma = this.turmaRepository.findById(cdTurma);
        if (turma.isPresent()){
        	this.turmaRepository.deleteById(cdTurma);
        }else{
            throw new NotFoundException("Não foi possível realizare a exclusão! Motivo: Não existe uma turma com o ideitificador especificado: " + cdTurma.toString());
        }
	}
	
	public TurmaDto atualizarTurma(TurmaDto turmaDto, Long cdTurma) {
		Optional<Turma> turma = this.turmaRepository.findById(cdTurma);
		
		if (turma.isPresent()) {
			Turma turmaExiste = new Turma();
			turmaExiste.setCdTurma(cdTurma);
			turmaExiste.setDsTurma(turmaDto.getDsTurma());
			turmaExiste.setcapacidade(turmaDto.getCapacidade());
			turmaExiste.setLocal(turmaDto.getLocal());
			
			return new TurmaDto(this.turmaRepository.save(turmaExiste));
			
		} else {
			throw new NotFoundException("Não existe uma turma com o ideitificador especificado: " + cdTurma.toString());
		}
	}

}
