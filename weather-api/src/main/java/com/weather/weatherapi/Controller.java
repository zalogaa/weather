package com.weather.weatherapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@org.springframework.stereotype.Controller
public class Controller {
	
	
	@GetMapping("/GetCity/{cityName}")
	public String getCity(@PathVariable String cityName){
		
		
		
		
		return null;
		
		
	}
	
	

}
