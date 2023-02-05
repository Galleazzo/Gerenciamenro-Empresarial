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

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.TipoEmpresa;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.EmpresaRepo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.TipoEmpresaRepo;

@Controller
@RequestMapping(path = "/Empresa/TipoEmpresa")
public class TipoEmpresaController {
	
	@Autowired
	private EmpresaRepo empresaRepo;
	
	@Autowired
	private TipoEmpresaRepo tipoEmpresaRepo;
	
	@GetMapping("/Cadastradas")
	public String todosTipo(Model model) {
		List<TipoEmpresa> list = tipoEmpresaRepo.findAll();
		model.addAttribute("lista", list);
		return "TiposEmpresa";
	}
	
	@GetMapping("/AdicionarNovo")
	public String adicionarNovo() {
		return "FormNovoTipo";
	}
	
	@PostMapping("/Nnew")
	public String Nnew(TipoEmpresa tipoEmpresa) {
		tipoEmpresaRepo.save(tipoEmpresa);
		return "redirect:/Empresa/TipoEmpresa/Cadastradas";
	}
	
	@GetMapping("/deletarTipo/{id}")
	public String deletar(@PathVariable Integer id) {
		tipoEmpresaRepo.deleteById(id);
		return "redirect:/Empresa/TipoEmpresa/Cadastradas";
	}
	
	
}
