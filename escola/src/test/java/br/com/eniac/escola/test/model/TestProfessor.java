package br.com.eniac.escola.test.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.eniac.escola.model.Professor;

public class TestProfessor {

	@Test
	public void test() {
		Professor p = new Professor();
		p.setId(1);
		Assert.assertNotNull("Id é obrigatório", p.getId());
		
	}

}
