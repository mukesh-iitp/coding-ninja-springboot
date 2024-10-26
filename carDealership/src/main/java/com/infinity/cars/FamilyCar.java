package com.infinity.cars;

import com.infinity.tyre.Tyre;

public class FamilyCar implements Car {

	String owner;
	Tyre tyre;	

	public FamilyCar(Tyre tyre) {
		this.tyre = tyre; //we are doing dependency injection
	}

	@Override
	public String getInfo() {
		return "a family car"+tyre.getTyreInfo();
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
