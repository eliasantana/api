package br.com.escola.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.api.repository.TurmaRepository;

@Service
public class TurmaServices {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	public TurmaServices() {
	}

}
