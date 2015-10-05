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

	@Override
	public boolean logar(String email, String senha) {
		try{
			em.createQuery("from PessoaFisica u where "
					+ "u.email = :l and u.senha = :s")
					.setParameter("l", email)
					.setParameter("s", senha).getSingleResult();
				return true;
			}catch(Exception e){
				return false;
			}
	}

	@Override
	public PessoaFisica searchByEmail(String email) {
		
		return em.find(PessoaFisica.class, email);
	}
	
	
	
}
