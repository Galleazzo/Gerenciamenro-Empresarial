package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.Funcionario;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.enuns.Cargo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.enuns.ContratoFuncionario;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.FuncionarioRepo;

@Controller
@RequestMapping(path = "/Funcionario")
public class FuncionarioController{
	
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
	
	@GetMapping("/deletarFuncionario")
	public String deletarFuncionario(@RequestParam Integer id) {
		funcionarioRepo.deleteById(id);
		return "redirect:/Funcionario/ListaFuncionario";
	}	
	
	
	
	@GetMapping("/editarFuncionario")
	public String editarFuncionario(@RequestParam Integer id, Model model) {
		Optional<Funcionario> funcionario = funcionarioRepo.findById(id);
		
		
		List<Funcionario> list = funcionarioRepo.findAll();
		
		int j = list.size();
		model.addAttribute("funcionario", funcionario);
		model.addAttribute("idFuncionario", j);
		
		
		model.addAttribute("cargo", Cargo.values());
		model.addAttribute("contratoFuncionario", ContratoFuncionario.values());
		return "funcionario/EditarFuncionario";
	}
	
	@PostMapping("/saveFuncionarioEdit")
	public String saveFuncionarioEdit(@RequestParam Integer id, @Validated Funcionario funcionario) {
		funcionarioRepo.save(funcionario);
		return "redirect:/Funcionario/ListaFuncionario";
	}
	
	/*
	 * public Page<Funcionario> findByCriteria(int page, int size, Model model){
	 * org.springframework.data.domain.Pageable paging = PageRequest.of(page, size);
	 * Iterable<Funcionario> list = funcionarioRepo.findAll(paging);
	 * 
	 * return paging; }
	 */
	
}
