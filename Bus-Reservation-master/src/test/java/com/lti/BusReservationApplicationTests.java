//package com.lti;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.lti.DTO.BusResultDTO;
//import com.lti.dao.BusSearchDao;
//import com.lti.dao.BusTimeTableDao;
//import com.lti.dao.DaoInterface;
//import com.lti.dao.GenericDao;
//import com.lti.dao.SeatDao;
//import com.lti.dao.TransportCompanyDao;
//import com.lti.entity.BusDetails;
//import com.lti.entity.BusTimeTable;
//import com.lti.entity.RouteDetails;
//import com.lti.entity.SeatDetails;
//import com.lti.entity.TransportCompany;
//import com.lti.entity.TripDetails;
//import com.lti.entity.WeeklyFrequency;
//import com.lti.service.BusSearchService;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@Rollback(false)
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class BusReservationApplicationTests {
//
//	 @Autowired 
//	private TransportCompanyDao tcdao;
//	 
//	 @Autowired
//	 private DaoInterface dao;
//	 
//	 @Autowired
//	 private BusSearchDao tddao;
//	 
//	 @Autowired
//	 private BusSearchService bss;
//	 
//	 @Autowired
//		BusTimeTableDao bdao;
//	@Test
//	public void addTranportCompanyTest() {
//	
//		TransportCompany company = new TransportCompany();
//		company.setCompanyName("SRM");
//		tcdao.insertNewTransportCompany(company);
//	}
//	
//	@Test
//	public void fetchAllTransportCompanyTest() {
//	
//		for(TransportCompany tc: tcdao.fetchDetailsOfAllTransport())
//			System.out.println(tc);
//	}
//	
//	@Test
//	public void fetchbyCompnameTest() {
//	
//			System.out.println(tcdao.fetchByCompanyName("SRM"));
//	}
//	
//	/*
//	 * @Test public void testtripdetailsInsert() { TripDetails td=new TripDetails();
//	 * LocalTime time = LocalTime.of(23,43); td.setArrivalTime(time);
//	 * td.setDepartureTime(LocalTime.of(05, 00));
//	 * 
//	 * td.setBus(dao.fetchByIdfromDatabase(BusDetails.class,3));
//	 * td.setWeeklyFrequency(dao.fetchByIdfromDatabase(WeeklyFrequency.class,3));
//	 * td.setRoute(dao.fetchByIdfromDatabase(RouteDetails.class,2));
//	 * 
//	 * dao.insertToDatabase(td); }
//	 */
//	
//	@Test
//	public void searchTest() throws ParseException {
//		
//		for(BusResultDTO brd:bss.busSearch("MUMBAI", "PUNE","2019-07-10"))
//			System.out.println(brd);
//	}
//	
//	@Test
//	public void addBusTest() {
//	
//		Date tempvar1 = null;
//		try {
//			tempvar1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-10");
//		} catch (ParseException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		String tempStartOfService =new SimpleDateFormat("dd-MMM-yy").format(tempvar1);
//		DateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
//		java.util.Date date1 = null;
//		try {
//			date1 = sdf1.parse(tempStartOfService);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		java.sql.Date startOfService = new java.sql.Date(date1.getTime());
//		
//		
//		Date tempvar2 = null;
//		try {
//			tempvar2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-10");
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		String tempEndOfService =new SimpleDateFormat("dd-MMM-yy").format(tempvar2);
//		
//		DateFormat sdf2 = new SimpleDateFormat("dd-MMM-yy");
//		java.util.Date date2 = null;
//		try {
//			date2 = sdf2.parse(tempEndOfService);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		java.sql.Date endOfService = new java.sql.Date(date2.getTime());
//		TransportCompany transportCompany=tcdao.fetchByCompanyName("SRM");
//		
//		BusDetails bus=new BusDetails();
//		bus.setBusType("AC");
//		bus.setStartOfService(startOfService);
//		bus.setEndOfService(endOfService);
//		bus.setTotalSeats(45);
//		bus.setTransportCompany(transportCompany);
//		
//		dao.insertToDatabase(bus);
//	}
//	
//	
//	
//	  @Test
//	  public void addSeats() {  
//	  //already entered 
//		  BusTimeTable bus=dao.fetchByIdfromDatabase(BusTimeTable.class,3); 
//	  for(int i=1;i<=40;i++) {
//	  SeatDetails seat = new SeatDetails(); 
//	  seat.setSeatNo(i);
//	  seat.setFree(true);
//	  seat.setBus(bus);
//	  dao.insertToDatabase(seat); }
//	  
//	  }
//	 
//	
//	
//	@Test
//	public void BusTimetableSearch() {
//		Date tempvar;
//		try {
//			tempvar = new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-10");
//			String travelDate =new SimpleDateFormat("dd-MMM-yy").format(tempvar);
//			System.out.println("Test Traveldate:"+travelDate);
//			BusTimeTable bus=bdao.findJourneyByDateandTripId(101,travelDate);
//			System.out.println(bus.getJourneyID());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Autowired
//	private SeatDao sdao;
//	
//	@Test
//	public void fetchingSeatsTest() {
//		
//		List<SeatDetails> list=sdao.fetchSeatsOfABus(5,3);
//		for(SeatDetails sdl:list)
//			System.out.println(sdl.getSeatNo());
//			
//	}
//	
//
//}
