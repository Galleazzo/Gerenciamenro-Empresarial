package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.Cliente;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.TipoCliente;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.ClienteRepo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.TipoClienteRepo;

@Controller
@RequestMapping(path = "/Cliente/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepo clienteRepo;
	
	@Autowired
	private TipoClienteRepo tipoClienteRepo;
	
	@GetMapping("/Cadastradas")
	public String verTodas(Model model) {
		List<Cliente> list = clienteRepo.findAll();
		model.addAttribute("lista", list);
		return "cliente/cliente/ListaCliente";
	}
	
	@GetMapping("/AdicionarNova")
	public String addN(Model model) {
		List<TipoCliente> list = tipoClienteRepo.findAll();
		model.addAttribute("lista", list);
		
		return "cliente/cliente/FormNovoCliente";
	}
	
	@PostMapping("/Nnew")
	public String add(Cliente cliente) {
		clienteRepo.save(cliente);
		return "redirect:/Cliente/Cliente/Cadastradas";
	}
	
	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable Integer id) {
		clienteRepo.deleteById(id);
		return "redirect:/Cliente/Cliente/Cadastradas";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Optional<Cliente> cliente = clienteRepo.findById(id);
		
		List<TipoCliente> tipoCliente = tipoClienteRepo.findAll();
		model.addAttribute("cliente", cliente);
		
		model.addAttribute("tipoCliente", tipoCliente);
		return "cliente/cliente/EditarCliente";
	}
	
	@PostMapping("/saveEditCliente/{id}")
	public String saveedit(@PathVariable Integer id,  @Validated Cliente cliente) {
		clienteRepo.save(cliente);
		return "redirect:/Cliente/Cliente/Cadastradas";
		
	}
	
	
	
	
	
}
