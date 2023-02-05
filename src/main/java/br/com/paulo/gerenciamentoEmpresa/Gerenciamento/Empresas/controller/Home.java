package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class Home {

	@GetMapping
	public String home() {
		return "Home";
	}
}