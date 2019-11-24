package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TRANSPORT_COMPANY")
public class TransportCompany {

	@Id
	@Column(name="COMPANY_ID")
	@GeneratedValue
	private int companyID;

	@Column(name="COMPANY_NAME", unique = true)
	private String companyName;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "transportCompany")
	List<BusDetails> buses;
	
	@Override
	public String toString() {
		return "TransportCompany [companyID=" + companyID + ", companyName=" + companyName + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyID;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
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
		TransportCompany other = (TransportCompany) obj;
		if (companyID != other.companyID)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		return true;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
