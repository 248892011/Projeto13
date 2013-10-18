import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Professor")
public class Professor implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@NotNull(message= "Matrícula é obrigatório!")
	@Column(name= "matricula")
	private String matricula;
	
	@NotNull(message= "Nome é obrigatório!")
	@Column(name= "nome")
	private String nome;
	
	@NotNull(message= "Data de nascimento é obrigatório!")
	@Column(name= "dataNascimento")
	private String dataNascimento;
	
	@NotNull(message= "RG é obrigatório!")
	@Column(name= "rg")
	private String rg;
	
	@NotNull(message= "CPF é obrigatório!")
	@Column(name= "cpf")
	private String cpf;
	
	@NotNull(message= "Sexo é obrigatório!")
	@Column(name= "sexo")
	private String sexo;
	
	@NotNull(message= "dataContratacao é obrigatório!")
	@Column(name= "dataContratacao")
	private String dataContratacao;
	
	@NotNull(message= "pis é obrigatório!")
	@Column(name= "pis")
	private String pis;

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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
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

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
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
		
		return getMatricula() + " - " + getNome();
	}
	}
	