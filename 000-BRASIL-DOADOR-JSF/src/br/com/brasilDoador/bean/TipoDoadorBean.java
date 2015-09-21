package br.com.brasilDoador.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.brasilDoador.daoimpl.TipoDoadorDAOImpl;
import br.com.brasilDoador.entity.TipoDoador;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.singleton.EMFSingleton;

@ManagedBean
@RequestScoped
public class TipoDoadorBean {
	
	private TipoDoador tipoDoador;
	private TipoDoadorDAOImpl dao;
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			dao.insert(tipoDoador);
			msg = new FacesMessage("Tipo de Doador Cadastrado com Sucesso!");
		} catch (DBCommitException e) {
		
			e.printStackTrace();
			msg = new FacesMessage("Tipo de Doador Cadastrado com Sucesso!");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	@PostConstruct
	private void init(){
		
		tipoDoador = new TipoDoador();
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		
		dao = new TipoDoadorDAOImpl(em);
	}
	
	

	public TipoDoador getTipoDoador() {
		return tipoDoador;
	}

	public void setTipoDoador(TipoDoador tipoDoador) {
		this.tipoDoador = tipoDoador;
	}
	
	
	
}
