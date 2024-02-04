package br.com.escola.api.model;

import br.com.escola.api.dto.TurmaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Turma")
public class Turma {
	
	public Turma() {
	}
	
	public Turma(Long cdTurma, String dsTurma, int capacidade, String local) {
		this.cdTurma = cdTurma;
		this.dsTurma = dsTurma;
		this.capacidade = capacidade;
		this.local = local;
	}

	public Turma(TurmaDto turmaDto) {
		this.cdTurma = turmaDto.getCdTurma();
		this.dsTurma = turmaDto.getDsTurma().replaceAll(" ","");
		this.capacidade = turmaDto.getCapacidade();
		this.local = turmaDto.getLocal().replaceAll(" ","");;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdTurma;
	private String dsTurma;
	private int capacidade;
	private String local;
	
	
	public Long getCdTurma() {
		return cdTurma;
	}

	public void setCdTurma(Long cdTurma) {
		this.cdTurma = cdTurma;
	}

	public String getDsTurma() {
		return dsTurma;
	}

	public void setDsTurma(String dsTurma) {
		this.dsTurma = dsTurma;
	}
	
	public int getcapacidade() {
		return this.capacidade;
	}
	
	public void setcapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Turma [cdTurma=" + cdTurma + ", dsTurma=" + dsTurma + "Capacidade=" + capacidade +   ", local=" + local + "]";
	}
	
}
