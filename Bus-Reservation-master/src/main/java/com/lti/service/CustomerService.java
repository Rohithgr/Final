package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public void addCustomer(Customer c) {
		boolean em=customerDao.checkIfEmailPresent(c.getEmail());
		
		//boolean ph=fetchCustomerByPhone_No(c.getPhone_no());
		System.out.println(c.getEmail());
		if((!em))
			customerDao.addCustomer(c);
	}

	public boolean fetchCustomerByEmail(String email) {
		
		 if(customerDao.checkIfEmailPresent(email)){
			 return true;// true means email doesnt exist in db
		 }
		 return false;
	}
	public boolean fetchCustomerByPhone_No(double phone_no) {
		
		if( customerDao.checkIfPhone_NoPresent(phone_no)) {
			return true;
		}
		return false;
	}
	
}
