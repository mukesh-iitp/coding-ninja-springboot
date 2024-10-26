package com.example.WeatherForecast;

import java.util.Random;

public class myForecast implements WeatherForecast {



	@Override
	public String getWeather() {
		String forecasts[] = {"Sunny", "Cloudy", "Rainy", "Windy", "Snowy"};
		Random random = new Random();
		int index = random.nextInt(forecasts.length);
		return forecasts[index];

	}

}
