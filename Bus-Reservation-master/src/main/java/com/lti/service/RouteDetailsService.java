package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.DTO.RouteDTO;
import com.lti.dao.RouteDetailsDao;

import com.lti.entity.RouteDetails;

@Service
public class RouteDetailsService {

	@Autowired
	private RouteDetailsDao rdd;
	
	@Transactional
	public void addRouteDetails(RouteDetails r) {
		boolean em=rdd.checkIfAlreadyPresentInDatabase(r.getSource(), r.getDestination());
		
		//boolean ph=fetchCustomerByPhone_No(c.getPhone_no());
	
		if((!em))
			rdd.addRouteDetails(r);
	}
	
	/*
	 * public RouteDTO fetchDetails(RouteDTO routeDTO){ RouteDTO route = null;
	 * RouteDetails rd = rdd.fetchRouteDetails();
	 * if(route.getDestination().equals(rd.getDestination())) { route=new
	 * RouteDTO(); }
	 * 
	 * return route;
	 * 
	 * 
	 * }
	 */

}
