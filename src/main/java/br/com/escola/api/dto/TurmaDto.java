package br.com.escola.api.dto;

import br.com.escola.api.model.Turma;

public class TurmaDto {

	public TurmaDto() {
	}
	
	public TurmaDto(Long cdTurma, String dsTurma, int capacidade, String local) {
		this.cdTurma = cdTurma;
		this.dsTurma = dsTurma;
		this.capacidade = capacidade;
		this.local = local;
	}

	public TurmaDto(Turma turma) {
		this.cdTurma = turma.getCdTurma();
		this.dsTurma = turma.getDsTurma();
		this.capacidade = turma.getcapacidade();
		this.local = turma.getLocal();
	}
	
	private Long cdTurma; 
	private String dsTurma;
	private int capacidade;
	private String local;
	
	public Long getCdTurma() {
		return cdTurma;
	}

	public String getDsTurma() {
		return dsTurma;
	}
	
	public int getCapacidade() {
		return capacidade;
	}

	public String getLocal() {
		return local;
	}

	@Override
	public String toString() {
		return "TurmaDto{" +
				"cdTurma=" + cdTurma +
				", dsTurma='" + dsTurma + '\'' +
				", capacidade=" + capacidade +
				", local='" + local + '\'' +
				'}';
	}
}
