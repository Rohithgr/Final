package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;
import com.lti.service.CustomerService;


@RestController
public class RegisterController {
	@Autowired
	CustomerService service;
	
	
	
	@RequestMapping("/register")
	public  void register(@RequestBody Customer customer) {
	
		service.addCustomer(customer);
		System.out.println("CUSTOMER REGISTERED");
		System.out.println(customer.getEmail());
	}
	
	@RequestMapping("/registerPage")
	public ModelAndView registerPage()
	{
		ModelAndView modelAndView = new ModelAndView("UserRegistration");
		return modelAndView;
	}

}
