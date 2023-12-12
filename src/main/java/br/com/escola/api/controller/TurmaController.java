package br.com.escola.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.escola.api.services.TurmaServices;

@Controller
@RequestMapping("/Turma")
public class TurmaController {
	
	@Autowired
	TurmaServices turmaService;

}
