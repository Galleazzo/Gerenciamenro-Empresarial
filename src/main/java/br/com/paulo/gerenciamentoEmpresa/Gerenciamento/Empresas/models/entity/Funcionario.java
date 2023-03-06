package br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.enuns.Cargo;
import br.com.paulo.gerenciamentoEmpresa.Gerenciamento.Empresas.models.enuns.ContratoFuncionario;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double salario;
	private String telefone;
	private String email;
	private String cnpj;
	private String setor;
	private Cargo cargo;
	private ContratoFuncionario contratoFuncionario;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String email, Double salario, String setor, Cargo cargo, String cnpj, ContratoFuncionario contratoFuncionario, String telefone) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.setor = setor;
		this.cargo = cargo;
		this.cnpj = cnpj;
		this.contratoFuncionario = contratoFuncionario;
		this.telefone = telefone;
		this.email = email;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ContratoFuncionario getContratoFuncionario() {
		return contratoFuncionario;
	}

	public void setContratoFuncionario(ContratoFuncionario contratoFuncionario) {
		this.contratoFuncionario = contratoFuncionario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
