package br.com.brasilDoador.dao;

import java.util.List;

import br.com.brasilDoador.entity.Sexo;

public interface SexoDAO extends DAO<Sexo,Integer>{
	
	public List<Sexo> listar();
	
}
