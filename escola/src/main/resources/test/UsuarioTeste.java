package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.eniac.escola.model.Usuario;

public class UsuarioTeste {
	
	private Usuario u = null;
	private interger id = 1;
	
	@Before
	public void setUp() throws Exception {
		u = new Usuario ();
		u.setId (id);
		u.setLogin ("248892011");
		u.Nome ("User");
		u.Senha ("20132013");
		u.setSituação ("A");
	
	}

	@Test
	public void test() {
		assertNotNull(u);
		assertEquals(id, u.getId());
		assertEquals ("20132103", u.getLogin());
	}

}
