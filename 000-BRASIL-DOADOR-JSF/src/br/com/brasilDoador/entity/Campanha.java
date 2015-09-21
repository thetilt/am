package br.com.brasilDoador.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seqCampanha",sequenceName="SEQ_NAME",allocationSize=1)
@Table(name="BDTB_CAMPANHA")
public class Campanha {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCampanha")
	@Column(name="cd_campanha")
	private int id;
	
	@Column(name="nm_campanha", nullable=false)
	private String descricao;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DT_INICIO")
	private Calendar dataInicio;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DT_FIM")
	private Calendar dataFim;
	
	@ManyToOne
	@JoinColumn(name="CD_PESSOA_JURIDICA")
	private PessoaJuridica pj;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataFim() {
		return dataFim;
	}
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	public PessoaJuridica getPj() {
		return pj;
	}
	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}
	
	
	
}
