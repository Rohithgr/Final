package com.lti.dao;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.BusTimeTable;

@Repository
public class BusTimeTableDao {

	@Autowired
	private EntityManager em;
	
	public BusTimeTable findJourneyByDateandTripId(int tripID, String jdate) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		java.util.Date date = sdf.parse(jdate);
		java.sql.Date sqlDate = new Date(date.getTime());
		System.out.println(sqlDate);
		Query q= em.createQuery("select BT from BusTimeTable BT inner join BT.trip TD where TD.tripId=:id and BT.date=:jd ");
			 q.setParameter("id",tripID);
			 q.setParameter("jd",sqlDate);
		/*
		 * List<BusTimeTable> btt=q.getResultList(); for(BusTimeTable list:btt)
		 * System.out.println(list.getTrip());
		 */
			
			return (BusTimeTable)q.getSingleResult();
		
	}
	
	public void UpdateFreeSeats(BusTimeTable bus) {
		em.merge(bus);
	}
}
