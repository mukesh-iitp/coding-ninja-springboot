package com.example.WeatherForecast;

public class myUser implements User {

	String name;
	int age;
	Location location;
	WeatherForecast weatherForecast;

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setWeatherForecast(WeatherForecast weatherForecast) {
		this.weatherForecast = weatherForecast;
	}

	@Override
	public void setUserDetails(String name, int age) {
		this.name=name;
		this.age=age;
	}

	void init(){
		System.out.println("The user bean has been Instantiated I am init() method");
	}

	void destroy(){
		System.out.println("The user bean has been destroyed I am destroy() method");
	}


	@Override
	//public void setLocationDetails(Location location) {
	public void setLocationDetails(String city, String state, String country) {
		this.location.setLocation(city, state, country);
	}

	@Override
	public void getWeatherForecastForLocation() {
		System.out.println("Hi " + this.name + " weather in your city " + location.getLocation()+ " is " + weatherForecast.getWeather());
	}




}
