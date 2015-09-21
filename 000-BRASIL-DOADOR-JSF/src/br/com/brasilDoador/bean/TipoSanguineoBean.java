package br.com.brasilDoador.bean;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.brasilDoador.daoimpl.TipoSanguineoDAOImpl;
import br.com.brasilDoador.entity.TipoSanguineo;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.singleton.EMFSingleton;

@ManagedBean
@RequestScoped
public class TipoSanguineoBean {
	
	private TipoSanguineo tipoSanguineo;
	
	private TipoSanguineoDAOImpl dao;
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			
			dao.insert(tipoSanguineo);
			msg = new FacesMessage("Tipo Sanguineo Cadastrado !!");
			
		} catch (DBCommitException e) {
			
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Cadastrar!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
		
	@PostConstruct
	private void init(){
		tipoSanguineo = new TipoSanguineo();
		EntityManager  em = EMFSingleton.getInstance().createEntityManager();
		dao = new TipoSanguineoDAOImpl(em);
	}

	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	
	
	
}
