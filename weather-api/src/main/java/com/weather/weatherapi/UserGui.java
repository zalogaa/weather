package com.weather.weatherapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class UserGui extends VerticalLayout {

	private TextField tfCity;
	private Button buttonSend;
	@Autowired
	private CityService cityService;
	private TextArea taCities;
	@Autowired
	private RestTemplate restTemplate;

	public UserGui() {
		this.tfCity = new TextField("city");
		this.buttonSend = new Button("send");
		taCities = new TextArea("cities with temperaturies");
		buttonSend.addClickListener(clickEvent -> {
			addCity(tfCity.getValue());
			showCitiesWithTemperaturies();
		});
		add(tfCity);
		add(buttonSend);
		add(taCities);
	}

	public void addCity(String city) {
		cityService.addCity(new City(city));
	}

	public void showCitiesWithTemperaturies() {
		List<City> cities = cityService.getAllCities();

		StringBuffer sb = new StringBuffer();

		cities.forEach(x -> {
			ResponseEntity<String> cityResponse = restTemplate.exchange(
					"https://samples.openweathermap.org/data/2.5/weather?q=" + x.getCityName()
							+ ",uk&appid=bd1a5f6d8fed8c14c5caace65591ef23",
					HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
					});
			sb.append(cityResponse.getBody() + "\n");
		});

		taCities.setValue(sb.toString());
	}

}
