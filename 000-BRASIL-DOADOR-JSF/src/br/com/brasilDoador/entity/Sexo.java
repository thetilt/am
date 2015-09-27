package br.com.brasilDoador.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.brasilDoador.validacoes.BaseEntity;

@Entity
@SequenceGenerator(name="seqTipoSanguineo",sequenceName="SEQ_TIPO_SANGUINEO",allocationSize=1)
@Table(name="BDTB_SEXO")
public class Sexo implements Serializable, BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 198798L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTipoSanguineo")
	@Column(name="CD_SEXO")
	private int id;
	
	@Column(name="DS_DESCRICAO",nullable=false)
	private String descricao;
	
	public Integer getId() {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sexo other = (Sexo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
