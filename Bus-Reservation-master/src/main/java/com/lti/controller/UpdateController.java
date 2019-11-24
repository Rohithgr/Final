package com.lti.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.DTO.UpdateBusDTO;
import com.lti.service.UpdateBusService;

@RestController
public class UpdateController {
	
	@Autowired
	private UpdateBusService updateBusService;
	
	@RequestMapping(path="/update",method=RequestMethod.POST)
	public void updateBus(@RequestBody UpdateBusDTO updates) {
		try {
			updateBusService.update(updates);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
