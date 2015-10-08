package br.com.brasilDoador.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.brasilDoador.dao.PessoaFisicaDAO;
import br.com.brasilDoador.daoimpl.PessoaFisicaDAOImpl;
import br.com.brasilDoador.entity.PessoaFisica;
import br.com.brasilDoador.singleton.EMFSingleton;

@ManagedBean
@RequestScoped
public class LoginBean {

	private PessoaFisicaDAO dao;
	
	private String email;
	private String senha;
	
	@PostConstruct
	private void init(){
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		dao = new PessoaFisicaDAOImpl(em);
		
	}
	
	public String deslogar(){
		//Recuperar a sess�o do usu�rio
		HttpSession sessao = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext()
				.getSession(true);
		//Invalidar a sess�o
		sessao.invalidate();
		return "login";
	}
	


	public String logar(){
		if (dao.logar(email, senha)){
			//Recuperar a sess�o do usu�rio
			HttpSession sessao = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(true);
			//Recupera o usu�rio do DB
			//PessoaFisica usuario = dao.searchByEmail(pessoaFisica.getEmail());
			//Colocar uma informa�ao na sess�o
			sessao.setAttribute("nome", email);
			
			return "cadastro-tipo-sanguineo"; //Navega para a p�gina Index
		}else{
			FacesContext.getCurrentInstance()
				.addMessage(null,
				new FacesMessage("Usuario e/ou senha invalidos"));
			return "login"; //Volta para a p�gina de login
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
		
	
	
}
