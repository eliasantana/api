package br.com.escola.api.services;

import br.com.escola.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunosServices {
    @Autowired
    AlunoRepository repository;
}
