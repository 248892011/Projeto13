package br.com.eniac.escola.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Professor")
public class Professor  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprofessor")
	private Integer id;
	
	@NotNull
	@Column(name="matricula")
	private String matricula;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@Column(name="dataNascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="rg")
	private String rg;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="dataContratacao")
	@Temporal(TemporalType.DATE)
	private Date dataContratacao;
	
	@Column(name="pis")
	private String pis;
	
	
	public Professor(){
	}
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getMatricula() {
		return matricula;
	}




	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public Date getDataNascimento() {
		return dataNascimento;
	}




	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}




	public String getRg() {
		return rg;
	}




	public void setRg(String rg) {
		this.rg = rg;
	}




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public String getSexo() {
		return sexo;
	}




	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public Date getDataContratacao() {
		return dataContratacao;
	}




	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}




	public String getPis() {
		return pis;
	}




	public void setPis(String pis) {
		this.pis = pis;
	}




	@Override
	public String toString() {
		return getId()+"-"+getNome();
	}
}
