package br.com.escola.api.controller;

import br.com.escola.api.services.AlunosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
    @Autowired
    AlunosServices services;
}
