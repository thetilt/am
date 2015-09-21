package br.com.brasilDoador.bean;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.brasilDoador.daoimpl.PessoaJuridicaDAOImpl;
import br.com.brasilDoador.entity.PessoaJuridica;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.singleton.EMFSingleton;

@ManagedBean
@RequestScoped
public class PessoaJuridicaBean {
	
	private PessoaJuridica pessoaJuridica;
	private PessoaJuridicaDAOImpl dao;
	
	public void cadastrar(){
		
		FacesMessage msg;
		
		try {
			
			dao.insert(pessoaJuridica);
			msg = new FacesMessage("Pessoa Física "+ pessoaJuridica.getNome() +" Cadastrada!");
			
		} catch (DBCommitException e) {
			
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Cadastrar!");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	@PostConstruct
	private void init(){
		pessoaJuridica = new PessoaJuridica();
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		dao = new PessoaJuridicaDAOImpl(em);
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	
	

}
