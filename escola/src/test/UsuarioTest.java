package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.eniac.escola.model.Usuario;

@Ignore
public class UsuarioTest {

	private Usuario u = null;
	private Integer id = 1;
	
	@Ignore
	@Before
	public void setUp() throws Exception {
		u = new Usuario();
		u.setId(id);
		u.setLogin("20212012");
		u.setNome("Usuário");
		u.setSenha("****");
		u.setSituacao("A");
	}

	@Ignore
	@Test
	public void test() {
		assertNotNull(u);
		assertEquals(id, u.getId());
		assertEquals("20212012", u.getLogin());
	}

}
