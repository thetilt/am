package br.com.brasilDoador.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.TipoSanguineoDAO;
import br.com.brasilDoador.entity.TipoSanguineo;

public class TipoSanguineoDAOImpl extends DAOImpl<TipoSanguineo, Integer> implements TipoSanguineoDAO{

	public TipoSanguineoDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<TipoSanguineo> listar() {
		
		return em.createQuery("from TipoSanguineo",TipoSanguineo.class).getResultList();
	}
	
	

}
