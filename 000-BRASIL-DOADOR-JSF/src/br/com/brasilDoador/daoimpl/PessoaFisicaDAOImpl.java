package br.com.brasilDoador.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasilDoador.entity.PessoaFisica;

public class PessoaFisicaDAOImpl extends DAOImpl<PessoaFisica, Integer>{

	public PessoaFisicaDAOImpl(EntityManager em) {
		super(em);
		
	}
	
	
	
}
