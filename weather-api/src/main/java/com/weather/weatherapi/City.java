package com.weather.weatherapi;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	private Long id;
	
	private String cityName;

	public City(String cityName) {

		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}