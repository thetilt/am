package br.com.brasilDoador.daoimpl;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.TipoDoadorDAO;
import br.com.brasilDoador.entity.TipoDoador;

public class TipoDoadorDAOImpl extends DAOImpl<TipoDoador, Integer> implements TipoDoadorDAO{

	public TipoDoadorDAOImpl(EntityManager em) {
		super(em);
		
	}

}
