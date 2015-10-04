package br.com.brasilDoador.dao;

import java.util.List;
import br.com.brasilDoador.entity.Campanha;


public interface CampanhaDAO extends DAO<Campanha, Integer> {
	
	public List<Campanha> listar();
	
}
