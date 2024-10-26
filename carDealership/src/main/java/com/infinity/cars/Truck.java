package com.infinity.cars;

import com.infinity.tyre.Tyre;

public class Truck implements Car {
	
	String owner;
	Tyre tyre;	

	public Truck(Tyre tyre) {
		this.tyre = tyre; //we are doing dependency injection
	}

	@Override
	public String getInfo() {
		return "a truck"+tyre.getTyreInfo();
	}

	@Override
	public void setOwnerName(String name) {

	}

	@Override
	public String getOwnerName() {
		return null;
	}

}
