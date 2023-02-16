package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String cnpj;
	
	@OneToOne
	private TipoCliente tipoCliente;
	
	private String descricao;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String cnpj, TipoCliente tipoCliente, String descricao) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.tipoCliente = tipoCliente;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoCliente getTipoEmpresa() {
		return tipoCliente;
	}

	public void setTipoEmpresa(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
