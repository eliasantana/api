package br.com.escola.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.escola.api.services.FuncionarioServices;

@Controller
public class FuncionarioController {
	
	@Autowired
	FuncionarioServices funcionarioServices;

}
