package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.DTO.CustomerDTO;
import com.lti.DTO.LoginDTO;
import com.lti.dao.CustomerDao;
import com.lti.dao.LoginDao;
import com.lti.entity.Customer;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public CustomerDTO showSearch(LoginDTO loginDetail){
		CustomerDTO cust = null;
		Customer customer = loginDao.fetchEmail(loginDetail.getEmail());
		System.out.println("fetched");
		if(customer.getPassword().equals(loginDetail.getPassword())) {
			 cust=new CustomerDTO(customer);
		}
		else {
			cust=new CustomerDTO();
			cust.setCustomerId(-1);			
		}
		return cust;


	}
	
		
	
}
