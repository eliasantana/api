package br.com.escola.api.dto;

import br.com.escola.api.model.Turma;

public class TurmaDto {

	public TurmaDto() {
	}
	
	public TurmaDto(Long cdTurma, String dsTurma, String local) {
		this.cdTurma = cdTurma;
		this.dsTurma = dsTurma;
		this.local = local;
	}

	public TurmaDto(Turma turma) {
		this.cdTurma = turma.getCdTurma();
		this.dsTurma = turma.getDsTurma();
		this.local = turma.getLocal();
	}
	
	private Long cdTurma; 
	private String dsTurma; 
	private String local;
	
	public Long getCdTurma() {
		return cdTurma;
	}

	public String getDsTurma() {
		return dsTurma;
	}

	public String getLocal() {
		return local;
	}	
}
