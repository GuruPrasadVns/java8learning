package com.classes;

public class WeatherData {
	float temprature;
	float pressure;
	float humidity;
	
	public float getTemprature() {
		return temprature;
	}
	public void setTemprature(float temprature) {
		this.temprature = temprature;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	public void measurmentsChanged() {
		float currentTemprature = getTemprature();
		float currentPressure = getPressure();
		float currentHumidity = getHumidity();
		
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
		currentConditionsDisplay.update(currentTemprature, currentPressure, currentHumidity);
		
		WeatherStatisticsDisplay weatherStatisticsDisplay = new WeatherStatisticsDisplay();
		weatherStatisticsDisplay.update(currentTemprature, currentPressure, currentHumidity);
		
		ForeCastDisplay foreCastDisplay = new ForeCastDisplay();
		foreCastDisplay.update(currentTemprature, currentPressure, currentHumidity);
	}
	
}
