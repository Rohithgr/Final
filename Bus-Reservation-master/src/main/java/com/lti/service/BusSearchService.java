package com.lti.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.DTO.BusResultDTO;
import com.lti.dao.BusSearchDao;
import com.lti.dao.BusTimeTableDao;
import com.lti.entity.BusTimeTable;
import com.lti.entity.TripDetails;

@Service
public class BusSearchService {

	@Autowired
	private BusSearchDao searchDao;
	
	@Autowired
	private BusTimeTableDao timeDao;
	
	public List<BusResultDTO> busSearch(String source, String destination,String unformattedTravelDate) throws ParseException {
		
		Date tempvar = new SimpleDateFormat("yyyy-MM-dd").parse(unformattedTravelDate);
		String travelDate =new SimpleDateFormat("dd-MMM-yy").format(tempvar);
		
		List<TripDetails> busSearchResult =new ArrayList<TripDetails>();
		try {
			busSearchResult= searchDao.busAvailabilitySearch(source, destination, travelDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<BusResultDTO> resultListDTO =new ArrayList<BusResultDTO>();
		
		for(TripDetails td:busSearchResult) {
			BusResultDTO resultDTO= new BusResultDTO();
			BusTimeTable bus=timeDao.findJourneyByDateandTripId(td.getTripId(),travelDate);
			resultDTO.setSeatsFree(bus.getSeatsFree());
			resultDTO.setFare(td.getFare());
			resultDTO.setTripId(td.getTripId());
			resultDTO.setTransportCompanyName(td.getBus().getTransportComapny().getCompanyName());
			resultDTO.setBusType(td.getBus().getBusType());
			resultDTO.setDepartureTime(td.getDepartureTime());
			resultDTO.setArrivalTime(td.getArrivalTime());
			resultDTO.setDuration(td.getRoute().getDuration());
			resultListDTO.add(resultDTO);
			
		}
		
		return resultListDTO;
		
	}
	
}
