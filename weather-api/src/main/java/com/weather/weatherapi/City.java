package com.weather.weatherapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cities")
public class City {

	@Column(name = "cityName", nullable = false)
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
s