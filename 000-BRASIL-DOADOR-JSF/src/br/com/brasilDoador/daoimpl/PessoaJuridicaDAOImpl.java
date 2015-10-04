package br.com.brasilDoador.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.PessoaJuridicaDAO;
import br.com.brasilDoador.entity.PessoaJuridica;

public class PessoaJuridicaDAOImpl extends DAOImpl<PessoaJuridica, Integer> implements PessoaJuridicaDAO{

	public PessoaJuridicaDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<PessoaJuridica> listar() {
		
		return em.createQuery("from PessoaJuridica",PessoaJuridica.class).getResultList();
	}

}
