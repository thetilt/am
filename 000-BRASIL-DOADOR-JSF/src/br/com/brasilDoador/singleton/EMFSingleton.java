package br.com.brasilDoador.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	
	private static EntityManagerFactory emf;
	
	private EMFSingleton(){}
	
	public static EntityManagerFactory getInstance(){
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		
		return emf;
	}

}
