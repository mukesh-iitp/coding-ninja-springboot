package com.example.CarService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CarService.domain.Vehicle;

/**

 1. Implement the interface Registration and Override the method registerCar() and getNewCar() in CarRegistrationService.
 2. Also,autowire car of type Vehicle and use it in method registerCar() and getNewCar().

**/

@Service
public class CarRegistrationService implements Registration {
	
	@Autowired
	Vehicle car;

	@Override
	public Boolean registerCar(String RegistrationNumber, String CarName,String CarDetails,String CarWork ) {
		car.createVehicle(RegistrationNumber, CarName, CarDetails, CarWork);
		return car.saveVehicleDetails();
		//return true;
	}

	@Override
	public Vehicle getNewCar() {
		return car;
	}

}
