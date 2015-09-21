package br.com.brasilDoador.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasilDoador.dao.SexoDAO;
import br.com.brasilDoador.entity.Sexo;

public class SexoDAOImpl extends DAOImpl<Sexo, Integer> implements SexoDAO{

	public SexoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Sexo> listar() {
		
		return em.createQuery("FROM Sexo",Sexo.class).getResultList();
	}
	
	
	

}
