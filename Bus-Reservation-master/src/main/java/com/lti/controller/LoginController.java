
 package com.lti.controller;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.web.bind.annotation.RequestBody; 
  import org.springframework.web.bind.annotation.RequestMapping; 
  import org.springframework.web.bind.annotation.RequestMethod; 
  import org.springframework.web.bind.annotation.RequestParam; 
  import org.springframework.web.bind.annotation.RestController;

import com.lti.DTO.CustomerDTO;
import com.lti.DTO.LoginDTO;
import com.lti.entity.Customer;

   
  import com.lti.service.LoginService;
  
  @RestController 
  public class LoginController {
  
  @Autowired 
  private LoginService loginService;
  
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public CustomerDTO fetch(@RequestBody LoginDTO loginDetails) {
		
		CustomerDTO custDTO = loginService.showSearch(loginDetails);
		return custDTO;
	}
  
  }