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
@SequenceGenerator(name="seqAgenda",sequenceName="SEQ_AGENDAMENTO",allocationSize=1)
@Table(name="BDTB_AGENDAMENTO")
public class PreAgendamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAgenda")
	@Column(name="cd_agendamento")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="CD_FISICA")
	private PessoaFisica pessoaFisica;
	
	
	@ManyToOne
	@JoinColumn(name="CD_JURIDICA")
	private PessoaJuridica pessoaJuridica;
	
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DT_AGENDAMENTO",nullable=false)
	private Calendar dataAgendamento;
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pj) {
		this.pessoaJuridica = pj;
	}
	
	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Calendar dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
	
	
	

}
