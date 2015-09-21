package br.com.brasilDoador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqDoador",sequenceName="SEQ_DOADOR",allocationSize=1)
@Table(name="BDTB_TIPO_DOADOR")
public class TipoDoador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqDoador")
	@Column(name="cd_tipo")
	private int id;
	
	@Column(name="ds_tipo")
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
