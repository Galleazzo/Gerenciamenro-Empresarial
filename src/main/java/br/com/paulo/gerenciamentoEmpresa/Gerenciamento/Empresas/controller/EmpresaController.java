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

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.Empresa;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.TipoEmpresa;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.EmpresaRepo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.TipoEmpresaRepo;

@Controller
@RequestMapping(path = "/Empresa/Empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepo empresaRepo;
	
	@Autowired
	private TipoEmpresaRepo tipoEmpresaRepo;
	
	@GetMapping("/Cadastradas")
	public String verTodas(Model model) {
		List<Empresa> list = empresaRepo.findAll();
		model.addAttribute("lista", list);
		return "EmpresaLista";
	}
	
	@GetMapping("/AdicionarNova")
	public String addN(Model model) {
		List<TipoEmpresa> list = tipoEmpresaRepo.findAll();
		model.addAttribute("lista", list);
		
		return "FormNovaEmpresa";
	}
	
	@PostMapping("/Nnew")
	public String add(Empresa empresa) {
		empresaRepo.save(empresa);
		return "redirect:/Empresa/Empresas/Cadastradas";
	}
	
	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable Integer id) {
		empresaRepo.deleteById(id);
		return "redirect:/Empresa/Empresas/Cadastradas";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Optional<Empresa> empresa = empresaRepo.findById(id);
		
		List<TipoEmpresa> tipoEmpresas = tipoEmpresaRepo.findAll();
		model.addAttribute("empresa", empresa);
		
		model.addAttribute("tipoEmpresas", tipoEmpresas);
		return "EditarEmpresa";
	}
	
	@PostMapping("/saveEditEmpresa/{id}")
	public String saveedit(@PathVariable Integer id,  @Validated Empresa empresa) {
		empresaRepo.save(empresa);
		return "redirect:/Empresa/Empresas/Cadastradas";
		
	}
	
	
	
	
	
}
