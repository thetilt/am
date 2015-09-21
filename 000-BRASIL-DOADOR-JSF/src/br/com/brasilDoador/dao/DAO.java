package br.com.brasilDoador.dao;

import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.exception.IDnotFoundException;

public interface DAO<T, K> {
	
	void insert(T entity) throws DBCommitException;
	void update(T entity) throws DBCommitException;
	void delete(K key) throws DBCommitException, IDnotFoundException;
	T searchById(K key);
	
}
