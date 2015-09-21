package br.com.brasilDoador.dao;

import java.util.List;

import br.com.brasilDoador.entity.PessoaFisica;



public interface PessoaFisicaDAO extends DAO<PessoaFisica, Integer>{
	
	public List<PessoaFisica> listar();

}
