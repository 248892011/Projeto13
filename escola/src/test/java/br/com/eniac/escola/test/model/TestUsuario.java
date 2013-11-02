package br.com.eniac.escola.test.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.eniac.escola.model.Usuario;

public class TestUsuario {

	@Test
	public void test() {
		Usuario u = new Usuario();
		u.setId(1);
		Assert.assertNotNull("Id é obrigatório", u.getId());
	}

}
