package br.com.brasilDoador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqTipoSanguineo",sequenceName="SEQ_TIPO_SANGUINEO",allocationSize=1)
@Table(name="BDTB_SEXO")
public class Sexo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTipoSanguineo")
	@Column(name="CD_SEXO")
	private int id;
	
	@Column(name="DS_DESCRICAO",nullable=false)
	private String descricao;
	
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
	
	

}
