package com.lti.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.DTO.PassengerListDTO;
import com.lti.DTO.Passengers;
import com.lti.DTO.TicketDTO;
import com.lti.dao.BusTimeTableDao;
import com.lti.dao.DaoInterface;
import com.lti.dao.SeatDao;
import com.lti.entity.BusTimeTable;
import com.lti.entity.GuestCustomer;
import com.lti.entity.ReservationDetails;
import com.lti.entity.SeatDetails;
import com.lti.entity.TripDetails;

@Service
public class TicketReservationService {

	@Autowired
	private DaoInterface dao;
	
	@Autowired
	BusTimeTableDao btt;
	
	@Autowired
	private SeatDao seatDao;
	
	@Transactional
	public TicketDTO makeReservation(PassengerListDTO passengers) {
		 int noOfPassengers=passengers.getPassengers().length;
		 ReservationDetails reserv=new ReservationDetails();
		 ReservationDetails r=new ReservationDetails();
		 TicketDTO ticket=new TicketDTO();
		 	String travelDate;
			Date tempvar;
			BusTimeTable bus = null;
			if(passengers.getCustomerId()==null)
			{
				try {
					tempvar = new SimpleDateFormat("yyyy-MM-dd").parse(passengers.getJourneyDate());
					travelDate =new SimpleDateFormat("dd-MMM-yy").format(tempvar);
				
					bus=btt.findJourneyByDateandTripId(passengers.getTripID(),travelDate);	
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					if(noOfPassengers<bus.getSeatsFree()) {
						List<SeatDetails> seats=seatDao.fetchSeatsOfABus(noOfPassengers, bus);
			 
			
					reserv.setPrice(noOfPassengers*(bus.getTrip().getFare()));
					reserv.setSeats(noOfPassengers);
			 
				
					DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
					Date date= new Date();
					reserv.setReservedOn(dateFormat.format(date));
			 
					reserv.setTrip(bus.getTrip());
					r=dao.insertToDatabase(reserv);//inserting and getting reservid to set in passengers
					//for guest users
					int i=0;
					List<Integer> s= new ArrayList<Integer>(); 
						for(Passengers list:passengers.getPassengers()) {
							GuestCustomer gCst=new GuestCustomer();
							gCst.setGender(list.getGender());
							gCst.setName(list.getName());
							gCst.setReservation(r);
							gCst.setSeat(seats.get(i));
							s.add(seats.get(i++).getSeatNo());
							dao.insertToDatabase(gCst);
						}
			 
			
						ticket.setReservID(r.getResrvID());
						ticket.setNoOfSeats(noOfPassengers);
						ticket.setS(s);
		 }
	
	
		}
			return ticket;

	
	}		
	
	
	
}
