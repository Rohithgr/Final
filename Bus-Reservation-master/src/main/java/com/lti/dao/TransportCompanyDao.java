package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.TransportCompany;

@Repository
public class TransportCompanyDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private DaoInterface dao;
	
	public TransportCompany insertNewTransportCompany(TransportCompany tc) {
		return dao.insertToDatabase(tc);
	}
	
	public List<TransportCompany> fetchDetailsOfAllTransport(){
		return dao.fetchAllFromDatabase(TransportCompany.class);
	}
	
	public TransportCompany fetchByCompanyName(String comapnyName) {
		
		return (TransportCompany) em.createQuery("select TC from TransportCompany TC where TC.companyName = :tcname").setParameter("tcname",comapnyName).getSingleResult();
	}
}
