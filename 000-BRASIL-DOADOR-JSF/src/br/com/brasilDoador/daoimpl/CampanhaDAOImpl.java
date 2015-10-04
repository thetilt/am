package br.com.brasilDoador.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.CampanhaDAO;
import br.com.brasilDoador.entity.Campanha;


public class CampanhaDAOImpl extends DAOImpl<Campanha, Integer> implements CampanhaDAO{

	public CampanhaDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<Campanha> listar() {
		
		return em.createQuery("from Campanha",Campanha.class).getResultList();
	}

}
