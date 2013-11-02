package br.com.eniac.escola.dao.imp;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.eniac.escola.dao.DaoGenerico;

@Transactional(readOnly=true, propagation= Propagation.REQUIRED)
public class DaoGenericoImp<T, ID extends Serializable> implements DaoGenerico<T, ID> {

	private EntityManager entityManager;
	
	private Class<T> oClass;
	
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	protected EntityManager getEntityManager(){
		if (entityManager == null) {
			throw new IllegalStateException("ERRO");
		}
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public DaoGenericoImp(){
		this.oClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	@Transactional(readOnly=false, propagation= Propagation.REQUIRED)
	public T salvar(T object) {
		getEntityManager().clear();
		getEntityManager().persist(object);
		return object;
	}

	public T pesquisarPorId(ID id) {
		return (T)getEntityManager().find(oClass, id);
	}

	@Transactional(readOnly=false, propagation= Propagation.REQUIRED)
	public T atualizar(T object) {
		getEntityManager().merge(object);
		return object;
	}

	@Transactional(readOnly=false, propagation= Propagation.REQUIRED)
	public void excluir(T object) {
		object = getEntityManager().merge(object);
		getEntityManager().remove(object);
	}

	@SuppressWarnings("unchecked")
	public List<T> todos() {
		String queryS = "SELECT obj FROM "+oClass.getSimpleName() + " obj";
		Query query = getEntityManager().createQuery(queryS);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String queryS, Map<String, Object> params) {
		Query query = getEntityManager().createQuery(queryS);
		for(String chave:params.keySet()){
			query.setParameter(chave, params.get(chave));
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String queryS, Map<String, Object> params,
			int maximo, int atual) {
		Query query = getEntityManager().createQuery(queryS).setMaxResults(maximo).setFirstResult(atual);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesq(String queryS) {
		Query query = getEntityManager().createQuery(queryS);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T pesqParam(String queryS, Map<String, Object> params) {
		Query query = getEntityManager().createQuery(queryS);
		for(String chave:params.keySet()){
			query.setParameter(chave, params.get(chave));
		}
		try{
			return (T)query.getSingleResult();
		} catch (NoResultException nre){
			return null;
		}
	}

}
