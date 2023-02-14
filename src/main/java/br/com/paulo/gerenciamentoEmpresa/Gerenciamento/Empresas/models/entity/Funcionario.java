package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.enuns.Cargo;

public class Funcionario {
	
	private Integer id;
	private String nome;
	private Double salario;
	private String setor;
	private Cargo cargo;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, Double salario, String setor, Cargo cargo) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.setor = setor;
		this.cargo = cargo;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
}
