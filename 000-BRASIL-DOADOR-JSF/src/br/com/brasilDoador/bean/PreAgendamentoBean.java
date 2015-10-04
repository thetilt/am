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

import br.com.brasilDoador.daoimpl.PessoaFisicaDAOImpl;
import br.com.brasilDoador.daoimpl.PessoaJuridicaDAOImpl;
import br.com.brasilDoador.daoimpl.PreAgendamentoDAOImpl;
import br.com.brasilDoador.entity.PessoaFisica;
import br.com.brasilDoador.entity.PessoaJuridica;
import br.com.brasilDoador.entity.PreAgendamento;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.singleton.EMFSingleton;

@ManagedBean
@RequestScoped
public class PreAgendamentoBean {
	
	private PreAgendamento preAgendamento;
	
	private PreAgendamentoDAOImpl dao;
	
	
	private List<PessoaJuridica> pj;
	
	/* Só será utilizado para alimentar o banco */
	private List<PessoaFisica> pf;
		
	EntityManager em = EMFSingleton.getInstance().createEntityManager();
	
	@PostConstruct
	private void init(){
		
		preAgendamento = new PreAgendamento();
		
		preAgendamento.setDataAgendamento(Calendar.getInstance());
		
		
						
		dao = new  PreAgendamentoDAOImpl(em);		
		
	}
	
	
	public void cadastrar(){
		
		FacesMessage msg;
		
		try {
			
			dao.insert(preAgendamento);
			msg = new FacesMessage("Cadastrado !!");
			
		} catch (DBCommitException e) {
			
			msg = new FacesMessage("Erro ao Cadastrar !!");
			
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);		
		
	}
	
	public PreAgendamento getPreAgendamento() {
		return preAgendamento;
	}

	public void setPreAgendamento(PreAgendamento preAgendamento) {
		this.preAgendamento = preAgendamento;
	}
	
	
	public List<PessoaJuridica> getPj() {
		pj = new ArrayList<PessoaJuridica>();
		PessoaJuridicaDAOImpl dao = new PessoaJuridicaDAOImpl(em);
		pj = dao.listar();
		return pj;
	}

	public void setPj(List<PessoaJuridica> pj) {
		this.pj = pj;
	}

	public List<PessoaFisica> getPf() {
		pf = new ArrayList<PessoaFisica>();
		PessoaFisicaDAOImpl dao = new PessoaFisicaDAOImpl(em);
		pf = dao.listar();
		return pf;
	}

	public void setPf(List<PessoaFisica> pf) {
		this.pf = pf;
	}


}
