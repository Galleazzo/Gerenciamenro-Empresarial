package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.TipoCliente;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.ClienteRepo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.TipoClienteRepo;

@Controller
@RequestMapping(path = "/Cliente/TipoCliente")
public class TipoClienteController {
	
	@Autowired
	private ClienteRepo clienteRepo;
	
	@Autowired
	private TipoClienteRepo tipoClienteRepo;
	
	@GetMapping("/Cadastradas")
	public String todosTipo(Model model) {
		List<TipoCliente> list = tipoClienteRepo.findAll();
		int x = list.size();
		model.addAttribute("lista", list);
		model.addAttribute("x", x);
		return "cliente/tipoCliente/TiposClientesLista";
	}
	
	@GetMapping("/AdicionarNovo")
	public String adicionarNovo() {
		return "cliente/tipoCliente/FormNovoTipo";
	}
	
	@PostMapping("/Nnew")
	public String Nnew(TipoCliente tipoEmpresa) {
		tipoClienteRepo.save(tipoEmpresa);
		return "redirect:/Cliente/TipoCliente/Cadastradas";
	}
	
	@GetMapping("/deletarTipo/{id}")
	public String deletar(@PathVariable Integer id) {
		try {
			tipoClienteRepo.deleteById(id);
			return "redirect:/Cliente/TipoCliente/Cadastradas";
		} catch (Exception e) {
			return "cliente/tipoCliente/ErroExcluir";
		}
	}
	
	
}
