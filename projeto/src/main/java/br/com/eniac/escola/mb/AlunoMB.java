package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.eniac.escola.model.Aluno;

@ManagedBean
@ViewScoped
public class AlunoMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Aluno aluno;


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

		
	
}
