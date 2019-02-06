package com.weather.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class UserGui extends VerticalLayout {

	private TextField tfCity;
	private Button buttonSend;
	@Autowired
	private CityService cityService;

	public UserGui() {
		this.tfCity = new TextField("city");
		this.buttonSend = new Button("send");
		buttonSend.addClickListener(clickEvent -> addCity(tfCity.getValue()));
		add(tfCity);
		add(buttonSend);
	}

	public void addCity(String city) {
		cityService.addCity(new City(city));
	}

}
