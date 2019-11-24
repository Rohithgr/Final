package com.lti.dao;

import java.util.List;

public interface DaoInterface {

	public <E> E insertToDatabase(E obj);
	public <E> List<E> fetchAllFromDatabase(Class<E> classname);
	public <E>  E  fetchByIdfromDatabase(Class <E> c,Object Id);
}
