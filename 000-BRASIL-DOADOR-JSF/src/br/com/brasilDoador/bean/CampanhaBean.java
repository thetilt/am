package br.com.brasilDoador.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.brasilDoador.daoimpl.CampanhaDAOImpl;
import br.com.brasilDoador.daoimpl.PessoaJuridicaDAOImpl;
import br.com.brasilDoador.entity.Campanha;
import br.com.brasilDoador.entity.PessoaJuridica;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.singleton.EMFSingleton;

@ManagedBean
@RequestScoped
public class CampanhaBean {
	
	private Campanha campanha;
	
	private CampanhaDAOImpl dao;
	
	private EntityManager em = EMFSingleton.getInstance().createEntityManager();
	
	/*Só será utilizado para alimentar o banco */
	private List<PessoaJuridica> listPessoa;
	
	
	public void cadsatrar(){
		
		FacesMessage msg;
		
		try {
			
			dao.insert(campanha);
			msg = new FacesMessage("Cadastrado !");
			
		} catch (DBCommitException e) {
			
			msg = new FacesMessage("Erro ao Cadastrar !!");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	@PostConstruct
	private void init(){
		
		campanha = new Campanha();
		campanha.setDataInicio(Calendar.getInstance());
		campanha.setDataFim(Calendar.getInstance());
		
		
		dao = new CampanhaDAOImpl(em);
		
	}
	
	
	
	
	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	/* deve ser removido após acrescentar registros */
	public List<PessoaJuridica> getListPessoa() {
		listPessoa = new ArrayList<PessoaJuridica>();
		PessoaJuridicaDAOImpl dao = new PessoaJuridicaDAOImpl(em);
		listPessoa = dao.listar();
		
		return listPessoa;
	}
	
	public void setListPessoa(List<PessoaJuridica> listPessoa) {
		this.listPessoa = listPessoa;
	}
	
	
	
	

}
