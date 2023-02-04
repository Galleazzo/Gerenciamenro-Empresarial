package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.Empresa;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.TipoEmpresa;

public interface TipoEmpresaRepo extends JpaRepository<TipoEmpresa, Integer>{

}
