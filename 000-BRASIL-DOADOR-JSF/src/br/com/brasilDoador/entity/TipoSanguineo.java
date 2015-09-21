package br.com.brasilDoador.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.brasilDoador.validacoes.SampleEntity;



@Entity
@SequenceGenerator(name="seqTipo",sequenceName="SEQ_TIPO",allocationSize=1)
@Table(name="BDTB_TIPO_SANGUINEO")
public class TipoSanguineo implements Serializable,SampleEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTipo")
	@Column(name="cd_tipo")
	private Long id;
	
	@Column(name="DS_tipo")
	private String descricao;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
