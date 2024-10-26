package com.example.WeatherForecast;

public interface User {
	
	public void setUserDetails(String name, int age);
	//public void setLocationDetails(Location location);
	void setLocationDetails(String city, String state, String country);
	public void getWeatherForecastForLocation();
	
}
