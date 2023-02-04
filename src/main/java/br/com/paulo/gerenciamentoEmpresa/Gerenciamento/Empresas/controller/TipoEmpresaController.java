package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.TipoEmpresa;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.EmpresaRepo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.TipoEmpresaRepo;

@Controller
@RequestMapping(path = "/TipoEmpresa")
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
	
	
	
}
