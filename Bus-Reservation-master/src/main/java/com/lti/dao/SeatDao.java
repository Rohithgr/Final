package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.BusTimeTable;
import com.lti.entity.SeatDetails;

@Repository
public class SeatDao {

	@Autowired
	private EntityManager em;
	
	@Autowired
	BusTimeTableDao busDao;//to update bus free seats
	
	public List<SeatDetails> fetchSeatsOfABus(int noOfSeats,BusTimeTable bus){
		
			System.out.println(bus.getJourneyID());
		  Query q= em.createQuery("select SD from SeatDetails SD inner join SD.bus BT where BT.journeyID=:id and SD.isFree=true"); 
		  q.setParameter("id",bus.getJourneyID()); 
		  q.setMaxResults(noOfSeats);
		  List<SeatDetails> list=(List<SeatDetails>)q.getResultList();
		  for(SeatDetails seat:list)//blocking the seats
		  {
			  seat.setFree(false);
			  em.merge(seat);
			  
		  }
		  bus.setSeatsFree(bus.getSeatsFree()-noOfSeats);
		 busDao.UpdateFreeSeats(bus);
		return list;
	}
}
