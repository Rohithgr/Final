package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.DTO.RouteDTO;
import com.lti.entity.Customer;
import com.lti.entity.RouteDetails;

@Repository
public class RouteDetailsDao {


	@PersistenceContext
	private EntityManager em;
	
	public void addRouteDetails(RouteDetails r) {
		em.merge(r);
	}
	
	public RouteDetails fetchRouteDetails(){
		RouteDetails rd=(RouteDetails) em.createQuery("select r from RouteDetails r ").getResultList();
		return rd;
		}
	
	public boolean checkIfAlreadyPresentInDatabase(String source, String destination ) {
		Long count = (Long) em.createQuery("select count(r) from RouteDetails r where r.source = :source and r.destination= :destination").setParameter("source",source).setParameter("destination", destination).getSingleResult();
		if(count == 1)
			return true;
		else
			return false;
	}

	public Customer fetchEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
