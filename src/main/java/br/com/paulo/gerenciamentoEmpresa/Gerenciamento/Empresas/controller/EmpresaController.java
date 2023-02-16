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
@RequestMapping(path = "/Empresa/Empresas")
public class EmpresaController {
	
	@Autowired
	private ClienteRepo clienteRepo;
	
	@Autowired
	private TipoClienteRepo tipoClienteRepo;
	
	@GetMapping("/Cadastradas")
	public String verTodas(Model model) {
		List<Cliente> list = clienteRepo.findAll();
		model.addAttribute("lista", list);
		return "empresa/empresa/EmpresaLista";
	}
	
	@GetMapping("/AdicionarNova")
	public String addN(Model model) {
		List<TipoCliente> list = tipoClienteRepo.findAll();
		model.addAttribute("lista", list);
		
		return "empresa/empresa/FormNovaEmpresa";
	}
	
	@PostMapping("/Nnew")
	public String add(Cliente cliente) {
		clienteRepo.save(cliente);
		return "redirect:/Empresa/Empresas/Cadastradas";
	}
	
	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable Integer id) {
		clienteRepo.deleteById(id);
		return "redirect:/Empresa/Empresas/Cadastradas";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Optional<Cliente> empresa = clienteRepo.findById(id);
		
		List<TipoCliente> tipoEmpresas = tipoClienteRepo.findAll();
		model.addAttribute("empresa", empresa);
		
		model.addAttribute("tipoEmpresas", tipoEmpresas);
		return "empresa/empresa/EditarEmpresa";
	}
	
	@PostMapping("/saveEditEmpresa/{id}")
	public String saveedit(@PathVariable Integer id,  @Validated Cliente empresa) {
		clienteRepo.save(empresa);
		return "redirect:/Empresa/Empresas/Cadastradas";
		
	}
	
	
	
	
	
}
