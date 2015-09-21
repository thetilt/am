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
	private PessoaFisica pessoafisica;
	
	@ManyToOne
	@JoinColumn(name="CD_JURIDICA")
	private PessoaJuridica pf;
	
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DT_AGENDAMENTO",nullable=false)
	private Calendar dataAgendamento;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DT_HORA_AGENDAMENTO",nullable=false)
	private Calendar horaAgendamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PessoaFisica getPessoafisica() {
		return pessoafisica;
	}
	public void setPessoafisica(PessoaFisica pessoafisica) {
		this.pessoafisica = pessoafisica;
	}
	public PessoaJuridica getPf() {
		return pf;
	}
	public void setPf(PessoaJuridica pf) {
		this.pf = pf;
	}
	
	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Calendar dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Calendar getHoraAgendamento() {
		return horaAgendamento;
	}
	public void setHoraAgendamento(Calendar horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}
	
	
	

}
