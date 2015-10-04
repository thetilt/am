package br.com.brasilDoador.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.PessoaFisicaDAO;
import br.com.brasilDoador.entity.PessoaFisica;

public class PessoaFisicaDAOImpl extends DAOImpl<PessoaFisica, Integer> implements PessoaFisicaDAO{

	public PessoaFisicaDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<PessoaFisica> listar() {
	
		return em.createQuery("from PessoaFisica",PessoaFisica.class).getResultList();
	}
	
	
	
}
