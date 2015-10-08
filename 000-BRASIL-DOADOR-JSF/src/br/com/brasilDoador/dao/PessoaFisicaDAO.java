package br.com.brasilDoador.dao;

import java.util.List;

import br.com.brasilDoador.entity.Pessoa;
import br.com.brasilDoador.entity.PessoaFisica;



public interface PessoaFisicaDAO extends DAO<PessoaFisica, Integer>{
	
	public List<PessoaFisica> listar();
	
	PessoaFisica searchByEmail(String email);
	
	boolean logar(String email, String senha);

}
