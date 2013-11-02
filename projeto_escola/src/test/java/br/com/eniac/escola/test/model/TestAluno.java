package br.com.eniac.escola.test.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.eniac.escola.model.Aluno;

public class TestAluno {

	@Test
	public void test() {
		Aluno a = new Aluno();
		a.setId(1);
		Assert.assertNotNull("Id é obrigatório", a.getId());
		
	}

}
