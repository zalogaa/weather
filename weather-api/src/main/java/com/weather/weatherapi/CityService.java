package com.weather.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public void addCity(City city) {
		cityRepository.save(city);
	}
}
