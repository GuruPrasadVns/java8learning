package com.classes;

import com.interfaces.Display;

public class WeatherStatisticsDisplay implements Display {

	@Override
	public void display() {
		System.out.print("WeatherStatisticsDisplay::display");
	}

	@Override
	public void update(float temprature, float pressure, float humidity) {
		// TODO Auto-generated method stub
		
	}

}
