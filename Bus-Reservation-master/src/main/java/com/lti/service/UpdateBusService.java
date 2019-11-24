package com.lti.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.DTO.UpdateBusDTO;
import com.lti.dao.DaoInterface;
import com.lti.dao.GenericDao;
import com.lti.dao.TransportCompanyDao;
import com.lti.entity.BusDetails;
import com.lti.entity.TransportCompany;

@Service
public class UpdateBusService {
	
	@Autowired
	private TransportCompanyDao transportdao;
	
	@Autowired
	 private DaoInterface dao;
	
	@Transactional
	public void update(UpdateBusDTO update) throws ParseException {
		//For Start of service
		Date tempvar1 = new SimpleDateFormat("yyyy-MM-dd").parse(update.getStartOfService());
		String tempStartOfService =new SimpleDateFormat("dd-MMM-yy").format(tempvar1);
		DateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
		java.util.Date date1 = sdf1.parse(tempStartOfService);
		java.sql.Date startOfService = new java.sql.Date(date1.getTime());
		
		//for end of service
		Date tempvar2 = new SimpleDateFormat("yyyy-MM-dd").parse(update.getEndOfSerivce());
		String tempEndOfService =new SimpleDateFormat("dd-MMM-yy").format(tempvar2);
		
		DateFormat sdf2 = new SimpleDateFormat("dd-MMM-yy");
		java.util.Date date2 = sdf2.parse(tempEndOfService);
		java.sql.Date endOfService = new java.sql.Date(date2.getTime());
		
		TransportCompany transportCompany=transportdao.fetchByCompanyName(update.getTransportCompanyName());
		System.out.println(transportCompany.getCompanyName());
		BusDetails bus= new BusDetails();
		if(transportCompany.equals(null)) {
			
			transportCompany.setCompanyName(update.getTransportCompanyName());
			TransportCompany tc=transportdao.insertNewTransportCompany(transportCompany);
			
			bus.setTransportCompany(tc);
			bus.setBusType(update.getBustype());
			bus.setTotalSeats(update.getSeats());
			bus.setStartOfService(startOfService);
			bus.setEndOfService(endOfService);
			dao.insertToDatabase(bus);
		}
		else {
			bus.setTransportCompany(transportCompany);
			bus.setBusType(update.getBustype());
			bus.setTotalSeats(update.getSeats());
			bus.setStartOfService(startOfService);
			bus.setEndOfService(endOfService);
			dao.insertToDatabase(bus);
			
		}
		
	}

}
