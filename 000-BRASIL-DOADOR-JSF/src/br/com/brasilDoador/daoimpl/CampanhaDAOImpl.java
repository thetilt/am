package br.com.brasilDoador.daoimpl;

import javax.persistence.EntityManager;

import br.com.brasilDoador.entity.Campanha;

public class CampanhaDAOImpl extends DAOImpl<Campanha, Integer>{

	public CampanhaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
