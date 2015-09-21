package br.com.brasilDoador.daoimpl;

import javax.persistence.EntityManager;

import br.com.brasilDoador.entity.PreAgendamento;

public class PreAgendamentoDAOImpl extends DAOImpl<PreAgendamento, Integer>{

	public PreAgendamentoDAOImpl(EntityManager em) {
		super(em);
		
	}

}
