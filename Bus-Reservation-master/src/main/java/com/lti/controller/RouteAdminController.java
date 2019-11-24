package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.DTO.RouteDTO;
import com.lti.entity.Customer;
import com.lti.entity.RouteDetails;
import com.lti.service.RouteDetailsService;

@RestController
public class RouteAdminController {
	
	@Autowired
	RouteDetailsService rds;
	
	@RequestMapping("/routedetails")
	public String onSubmit(@RequestBody RouteDetails routeDetails) {
	
		rds.addRouteDetails(routeDetails);
		return "This Route is Already Registered";
		
		
	}

}
