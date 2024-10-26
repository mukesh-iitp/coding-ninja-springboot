package com.example.WeatherForecast;

public class myLocation implements Location {
	
	String city;
	String state;
	String country;
	
	
    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    void init(){
        System.out.println("The location bean has been Instantiated I am init() method");
    }

   
	

	@Override
	public void setLocation(String city, String state, String country) {
		this.city=city;
		this.state=state;
		this.country=country;
	}

	@Override
	public String getLocation() {
		return this.city;
	}

}
