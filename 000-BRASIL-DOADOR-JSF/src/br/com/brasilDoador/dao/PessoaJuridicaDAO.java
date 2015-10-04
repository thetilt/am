package br.com.brasilDoador.dao;

import java.util.List;


import br.com.brasilDoador.entity.PessoaJuridica;

public interface PessoaJuridicaDAO extends DAO<PessoaJuridica, Integer>{
	
	public List<PessoaJuridica> listar();

}
