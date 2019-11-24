package com.lti.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.TripDetails;

@Repository
public class BusSearchDao {

	@PersistenceContext
	EntityManager em;
	
	public List<TripDetails> busAvailabilitySearch(String source, String destination, String travelDate) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		java.util.Date date = sdf.parse(travelDate);
		java.sql.Date sqlDate = new Date(date.getTime());
		Query q=em.createQuery("select TD from TripDetails TD inner join TD.bus BD inner join TD.weeklyFrequency WF where "
				+ "TD.route.routeId=(select RD.routeId from RouteDetails RD where RD.source=:src and RD.destination= :dest) "
				+ "and :date between BD.startOfService and BD.endOfService  "
				+ "and TD.seatsFree>0 "
				+ "and TD.weeklyFrequency.freqId in"
				+ "(select WFF.freqId from WeeklyFrequency WFF where WFF.wednesday is not null )");
		q.setParameter("src",source);
		q.setParameter("dest",destination);
		q.setParameter("date",sqlDate);
		return q.getResultList();
		
		/*
		 * List<TripDetails> tdl =q.getResultList(); for(TripDetails td:tdl)
		 * System.out.println(td);
		 */
		/*
		 * SELECT * FROM TBL_ALBUM INNER JOIN TBL_SONG ON
		 * TBL_ALBUM.ALBUM_ID=TBL_SONG.ALBUM_ID WHERE TBL_SONG.SINGER='ARR'; Query q=em.
		 * createQuery("select distinct s from Album a inner join a.songs s where s.singer= :artist"
		 * );
		 * 
		 * SELECT* FROM TRIP_DETAILS TD INNER JOIN BUS_DETAILS BD ON TD.BUS_ID=BD.BUS_ID
		 * INNER JOIN WEEKLY_FREQUENCY WF ON TD.FREQ_ID=WF.FREQ_ID WHERE
		 * TD.ROUTE_ID=(SELECT ROUTE_ID FROM ROUTE_DETAILS RD WHERE RD.R_SOURCE='MUMBAI'
		 * AND RD.R_DESTINATION='PUNE') AND '10-JUL-19' BETWEEN START_OF_SERVICE AND
		 * END_OF_SERVICE AND TD.FREQ_ID IN(SELECT FREQ_ID FROM WEEKLY_FREQUENCY WHERE
		 * WEDNESDAY IS NOT NULL )
		 */
	}
}
