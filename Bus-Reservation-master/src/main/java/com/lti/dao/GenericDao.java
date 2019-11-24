package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao implements DaoInterface{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public <E> E insertToDatabase(E obj) {
		 return em.merge(obj);
	}

	@Override
	public <E> List<E> fetchAllFromDatabase(Class<E> classname) {
		Query q= em.createQuery("select o from "+ classname.getName()+" o");
		List <E> list=q.getResultList();
		return list;
	}
	
	@Override
	public <E>  E  fetchByIdfromDatabase(Class <E> c,Object Id) {
		E obj= em.find(c, Id);
		return obj;
		
	}
}
