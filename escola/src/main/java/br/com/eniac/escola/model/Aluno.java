package br.com.eniac.escola.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="Aluno")
public class Aluno  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idaluno")
	private Integer id;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="celular")
	private String celular;
	
	@NotNull
	@Column(name="situacao")
	private String situacao;
	
	
	public Aluno(){
		this.situacao = "A";
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getSituacao() {
		return situacao;
	}



	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}



	@Override
	public String toString() {
		return getId()+"-"+getNome();
	}
}
