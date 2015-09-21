package br.com.brasilDoador.dao;

import java.util.List;

import br.com.brasilDoador.entity.TipoSanguineo;

public interface TipoSanguineoDAO extends DAO<TipoSanguineo, Integer>{
	
	public List<TipoSanguineo> listar();
	
}
