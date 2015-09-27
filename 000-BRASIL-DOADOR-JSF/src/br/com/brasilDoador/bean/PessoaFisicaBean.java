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
import br.com.brasilDoador.daoimpl.SexoDAOImpl;
import br.com.brasilDoador.daoimpl.TipoSanguineoDAOImpl;
import br.com.brasilDoador.entity.PessoaFisica;
import br.com.brasilDoador.entity.Sexo;
import br.com.brasilDoador.entity.TipoDoador;
import br.com.brasilDoador.entity.TipoSanguineo;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.singleton.EMFSingleton;


@ManagedBean
@RequestScoped
public class PessoaFisicaBean {
	
	/**
	 * 
	 */
	
	private PessoaFisica pessoaFisica;
	private PessoaFisicaDAOImpl dao;
	private List<TipoSanguineo> tipoDeSangue;
	private List<Sexo> sexo;
	
	
	
	
	public void cadastrar(){
		
		FacesMessage msg;
		
		try {
			
			dao.insert(pessoaFisica);
			msg = new FacesMessage("Cadastrado "+ pessoaFisica.getNome() +" , "
			+ pessoaFisica.getTipoSanguineo().getDescricao() +" , "+
			+ pessoaFisica.getId() + " com Sucesso !!");
			
		} catch (DBCommitException e) {
			
			msg = new FacesMessage("Erro ao Cadastrar !!");
			
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		
		
		
	}
	
	@PostConstruct
	private void init(){
		
		pessoaFisica = new PessoaFisica();
		pessoaFisica.setDataNascimento(Calendar.getInstance());
		pessoaFisica.setUltimaDoacao(Calendar.getInstance());
		
		TipoDoador tipoDoador = new TipoDoador();
		tipoDoador.setId(1);
		
		pessoaFisica.setTipo(tipoDoador);
		
		
				
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		dao = new PessoaFisicaDAOImpl(em);
		
		
		
		

		
		
	}
	
	public List<Sexo> getListarSexo(){
		
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		sexo = new ArrayList<Sexo>();
		SexoDAOImpl sexoDao = new SexoDAOImpl(em);
		sexo = sexoDao.listar();
		
		return sexo;
		
		
	}
	
	public List<TipoSanguineo> getListarSangue(){
		
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		tipoDeSangue = new ArrayList<TipoSanguineo>();
		TipoSanguineoDAOImpl tipoSangueDao = new TipoSanguineoDAOImpl(em);
		tipoDeSangue = tipoSangueDao.listar();
		
		return tipoDeSangue;
		
	}
	
	
	
	
	

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public List<TipoSanguineo> getTipoDeSangue() {
		return tipoDeSangue;
	}

	public void setTipoDeSangue(List<TipoSanguineo> tipoDeSangue) {
		this.tipoDeSangue = tipoDeSangue;
	}

	public List<Sexo> getSexo() {
		return sexo;
	}

	public void setSexo(List<Sexo> sexo) {
		this.sexo = sexo;
	}

	
	

	
	

}
