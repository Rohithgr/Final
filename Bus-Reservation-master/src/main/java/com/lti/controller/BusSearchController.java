package com.lti.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.DTO.BusResultDTO;
import com.lti.service.BusSearchService;

@RestController
public class BusSearchController {

	@Autowired
	private BusSearchService bss;
	
	@RequestMapping(value = "/BusSearch", method = RequestMethod.GET)
	public List<BusResultDTO> search(@RequestParam(name="source") String source,@RequestParam(name="destination") String destination, @RequestParam(name="journeyDate") String journeyDate ,@RequestParam(name="noOfseats") int noOfseats)  {
		System.out.println(journeyDate);
		try {
			return bss.busSearch(source, destination, journeyDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
}
