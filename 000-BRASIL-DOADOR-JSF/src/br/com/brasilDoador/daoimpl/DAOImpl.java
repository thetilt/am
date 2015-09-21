package br.com.brasilDoador.daoimpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.DAO;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.exception.IDnotFoundException;

public class DAOImpl<T,K> implements DAO<T, K>{
	
	private Class<T> classe;
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager em) {
		this.em = em;
		this.classe = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	
	@Override
	public void insert(T entity) throws DBCommitException {
		
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new DBCommitException("Erro ao Cadastrar");
			}
			
		}
		
	}

	@Override
	public void update(T entity) throws DBCommitException {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new DBCommitException("Erro ao Atualizar");
			}
			
		}	
		
	}

	@Override
	public void delete(K key) throws DBCommitException, IDnotFoundException {
		
		T entity = searchById(key);
		
		if (searchById(key) == null) {
			throw new IDnotFoundException("Registro não encontrado!");
		}
		
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new DBCommitException("Erro ao Remover");
			}
			
		}
		
	}

	@Override
	public T searchById(K key) {
		
		return em.find(classe, key);
	}

}
