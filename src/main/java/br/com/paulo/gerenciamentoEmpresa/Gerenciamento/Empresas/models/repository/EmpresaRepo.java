package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.Empresa;

public interface EmpresaRepo extends JpaRepository<Empresa, Integer>{

}
