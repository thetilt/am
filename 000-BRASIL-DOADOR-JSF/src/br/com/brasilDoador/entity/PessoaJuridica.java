package br.com.brasilDoador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BDTB_PJURIDICA")
public class PessoaJuridica extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="DS_CNPJ",nullable=false,length=20)
	private long cnpj;
	
	@Column(name="DS_RAZAO_SOCIAL",nullable=false,length=20)
	private String razaoSocial;
	
	@Column(name="ds_status_cadastro",nullable=false)
	private boolean statusCadastro;
	
	
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public boolean isStatusCadastro() {
		return statusCadastro;
	}
	public void setStatusCadastro(boolean statusCadastro) {
		this.statusCadastro = statusCadastro;
	}
	
	
	
	
	
}
