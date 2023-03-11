package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.Funcionario;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.enuns.Cargo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.enuns.ContratoFuncionario;
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
	
	@GetMapping("/AdicionarNovo")
	public String adicionarNovo(Model model) {
		model.addAttribute("cargos", Cargo.values());
		model.addAttribute("contrato", ContratoFuncionario.values());
		return "funcionario/NovoFuncionario";
	}
	
	@PostMapping("/SalvarFuncionario")
	public String SalvarFuncionario(Funcionario funcionario) {
		funcionarioRepo.save(funcionario);
		return "redirect:/Funcionario/ListaFuncionario";
	}
	
	@GetMapping("/deletarFuncionario/{id}")
	public String deletarFuncionario(@PathVariable Integer id) {
		funcionarioRepo.deleteById(id);
		return "redirect:/Funcionario/ListaFuncionario";
	}	
	
	@GetMapping("/editarFuncionario/{id}")
	public String editarFuncionario(@PathVariable Integer id, Model model) {
		Optional<Funcionario> funcionario = funcionarioRepo.findById(id);
		List<Funcionario> list = funcionarioRepo.findAll();
		int j = list.size();
		model.addAttribute("funcionario", funcionario);
		model.addAttribute("idFuncionario", j);
		model.addAttribute("cargos", Cargo.values());
		model.addAttribute("contrato", ContratoFuncionario.values());
		return "EditarFuncionario";
	}
	
	
	
	
	
	
	
	
}
