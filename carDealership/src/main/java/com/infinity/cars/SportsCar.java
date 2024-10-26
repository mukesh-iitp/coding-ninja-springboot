package com.infinity.cars;

import com.infinity.tyre.Tyre;

public class SportsCar implements Car {
	
	String owner;
	Tyre tyre;	

//	public SportsCar(Tyre tyre) {
//		this.tyre = tyre; //we are doing dependency injection
//	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	@Override
	public String getInfo() {
		return "a sports car"+tyre.getTyreInfo();
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
