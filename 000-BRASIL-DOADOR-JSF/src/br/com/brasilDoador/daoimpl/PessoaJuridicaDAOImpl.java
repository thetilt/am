package br.com.brasilDoador.daoimpl;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.PessoaJuridicaDAO;
import br.com.brasilDoador.entity.PessoaJuridica;

public class PessoaJuridicaDAOImpl extends DAOImpl<PessoaJuridica, Integer> implements PessoaJuridicaDAO{

	public PessoaJuridicaDAOImpl(EntityManager em) {
		super(em);
		
	}

}
