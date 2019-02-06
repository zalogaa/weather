package com.weather.weatherapi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class UserGui extends VerticalLayout {

	private TextField tfCity;
	private Button buttonSend;

	public UserGui() {
		this.tfCity = new TextField("city");
		buttonSend = new Button("send");
		add(tfCity);
		add(buttonSend);
	}

}
