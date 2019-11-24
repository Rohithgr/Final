package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class LoginDao {


	@PersistenceContext
	private EntityManager entityManager;
	
	public Customer fetchEmail(String email){
		Customer customer=(Customer) entityManager.createQuery("select c from Customer c where c.email = :email").setParameter("email",email).getSingleResult();
		return customer;


	}

}
