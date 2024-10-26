package com.infinity.cars;

import com.infinity.tyre.Tyre;

public class NormalCar implements Car {
	
	String owner;
	Tyre tyre;	

	public NormalCar(Tyre tyre) {
		this.tyre = tyre; //we are doing dependency injection
	}
	
	@Override
	public String getInfo() {
		return "a normal car";
	}

	@Override
	public void setOwnerName(String name) {
		this.owner = name;
	}

	@Override
	public String getOwnerName() {
		return this.owner;
	}

}
