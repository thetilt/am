package br.com.brasilDoador.teste;



import javax.persistence.EntityManager;

import br.com.brasilDoador.daoimpl.PessoaFisicaDAOImpl;
import br.com.brasilDoador.singleton.EMFSingleton;

public class TesteLogin {
	
	public static void main(String[] args) {
		
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		
		PessoaFisicaDAOImpl pfDao = new PessoaFisicaDAOImpl(em);
		
		if (pfDao.logar("pedrolemos@hotmail.com", "12345678")) {
			System.out.println("Logado");
		}else{
			System.out.println("Nao Logado");
		}
		
		
		
	}

}
