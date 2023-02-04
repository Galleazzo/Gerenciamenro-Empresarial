package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.EmpresaRepo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository.TipoEmpresaRepo;

@Controller
@RequestMapping(path = "/Empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepo empresaRepo;
	
	@Autowired
	private TipoEmpresaRepo tipoEmpresaRepo;
	
	
	
}
