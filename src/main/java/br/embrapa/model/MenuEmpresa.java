package br.embrapa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu_empresa")
public class MenuEmpresa { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cdempresa")
	private Long cdEmprsa;
	
	@Column(name="nmEmpresa")
	private String nmEmpresa;

	public Long getCdEmprsa() {
		return cdEmprsa;
	}

	public void setCdEmprsa(Long cdEmprsa) {
		this.cdEmprsa = cdEmprsa;
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
		result = prime * result + ((cdEmprsa == null) ? 0 : cdEmprsa.hashCode());
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
		if (cdEmprsa == null) {
			if (other.cdEmprsa != null)
				return false;
		} else if (!cdEmprsa.equals(other.cdEmprsa))
			return false;
		return true;
	}
	
	
	
}
