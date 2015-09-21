package br.com.brasilDoador.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="BDTB_PESSOA")
@SequenceGenerator(name="seqPessoa",sequenceName="SEQ_PESSOA",allocationSize=1)
public abstract class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqPessoa")
	@Column(name="CD_PESSOA")
	private int id;
	
	@Column(name="DS_EMAIL",nullable=false, length=100)
	private String email;
	
	@Column(name="NM_PESSOA",nullable=false, length=100)
	private String nome;
	
	@Column(name="DS_SENHA",nullable=false, length=50)
	private String senha;
			
	@Column(name="DS_TELEFONE",nullable=false, length=50)
	private String telefone;
	
	@Column(name="DS_ENDERECO",nullable=false, length=50)
	private String endereco;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	

}
