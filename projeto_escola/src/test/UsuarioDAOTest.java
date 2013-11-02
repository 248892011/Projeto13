package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.eniac.escola.dao.UsuarioDAO;
import br.com.eniac.escola.model.Usuario;

@Ignore
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class UsuarioDAOTest {

	private UsuarioDAO usuarioDAO;
	private Integer id =1;
	
	//@Autowired
	public void setUsuarioDAO(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
	private Usuario getUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome("TESTE");
		usuario.setLogin("LOGIN");
		usuario.setEmail("EMAIL");
		usuario.setSenha("****");
		usuario.setSituacao("A");
		return usuario;
	}
	
	@Test
	public void testSalvar() {
		Usuario usuario = null;
		usuario = usuarioDAO.salvar(getUsuario());
		assertNotNull(usuario);
		assertEquals(id,usuario.getId());
		assertEquals("TESTE",usuario.getNome());
	}

	@Test
	public void testAtualizar() {
		Usuario usuario = getUsuario();
		usuario.setId(id);
		usuario.setNome("TESTE 2");
		usuario = usuarioDAO.atualizar(usuario);
		assertNotNull(usuario);
		assertEquals("TESTE 2",usuario.getNome());
	}
	
	@Test
	public void testTodos() {
		List<Usuario> usuarios = usuarioDAO.todos();
		assertNotNull(usuarios);
		assertEquals(1,usuarios.size());
		assertEquals("TESTE 2",usuarios.get(0).getNome());
	}
	
	@Test
	public void testPesqParam() {
		Map<String, Object> params = new  HashMap<String,Object>();
		params.put("id", id);
		List<Usuario> usuarios = usuarioDAO.listPesqParam("SELECT u FROM Usuario u WHERE u.id=:id",params);
		assertNotNull(usuarios);
		assertEquals(1,usuarios.size());
		assertEquals("TESTE 2",usuarios.get(0).getNome());
	}
	
	@Test
	public void testPesquisarPorId() {
		Map<String, Object> params = new  HashMap<String,Object>();
		params.put("id", id);
		Usuario usuario = usuarioDAO.pesqParam("SELECT u FROM Usuario u WHERE u.id=:id",params);
		assertNotNull(usuario);
		
	}

	@Test
	public void testExcluir() {
		Usuario usuario = usuarioDAO.pesquisarPorId(id);
		usuarioDAO.excluir(usuario);
	}

}
