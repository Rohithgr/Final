package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class CustomerDao {
	
	@PersistenceContext
	EntityManager em;
	public Customer fetchByCustomerId(int customer_id) {
		return (Customer) em.createQuery("select c from Customer c where c.id = :id").setParameter("id", customer_id).getSingleResult();
	}
	
	public boolean checkIfEmailPresent(String email) {
		Long count = (Long) em.createQuery("select count(c) from Customer c where c.email = :email").setParameter("email",email).getSingleResult();
		if(count == 1)
			return true;
		else
			return false;
	}
	public boolean checkIfPhone_NoPresent(double phone_no) {
		Long count = (Long) em.createQuery("select c from Customer c where c.phone_no = :phone_no").setParameter("phone_no",phone_no).getSingleResult();
		if(count == 1)
			return true;
		else
			return false;
	} 
	public void addCustomer(Customer c) {
		System.out.println(c.getEmail());
		em.merge(c);
		
	}
	
}
