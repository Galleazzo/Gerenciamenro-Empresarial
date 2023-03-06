package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.Funcionario;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.FuncionarioRepo;

@Controller
@RequestMapping(path = "/Funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepo funcionarioRepo;
	
	
	@GetMapping("/ListaFuncionario")
	public String ListaFuncionarios(Model model) {
		List<Funcionario> lista = funcionarioRepo.findAll();
		int x = lista.size();
		model.addAttribute("lista", lista);
		model.addAttribute("qtdFuncionarios", x);
		return "funcionario/ListaFuncionario";
	}
}
