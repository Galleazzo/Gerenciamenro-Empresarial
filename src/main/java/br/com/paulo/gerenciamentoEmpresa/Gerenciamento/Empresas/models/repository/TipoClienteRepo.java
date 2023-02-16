package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity.TipoCliente;



public interface TipoClienteRepo extends JpaRepository<TipoCliente, Integer>{

}
