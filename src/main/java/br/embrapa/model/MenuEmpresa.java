package br.embrapa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="menu_empresa")
/*
 * @NamedNativeQuery( name = "recuperarEmpresSelecionada", query =
 * "select * from menu_empresa", resultClass=MenuEmpresa.class )
 */
public class MenuEmpresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdempresa")
	private Long cdEmpresa;
	
	@Column(name="nmempresa")
	private String nmEmpresa;
	
	
	public Long getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmprsa(Long cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}
	
	

	public String getNmEmpresa() {
		return nmEmpresa;
	}

	public void setNmEmpresa(String nmEmpresa) {
		this.nmEmpresa = nmEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEmpresa == null) ? 0 : cdEmpresa.hashCode());
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
		MenuEmpresa other = (MenuEmpresa) obj;
		if (cdEmpresa == null) {
			if (other.cdEmpresa != null)
				return false;
		} else if (!cdEmpresa.equals(other.cdEmpresa))
			return false;
		return true;
	} 
	
	

	
}
