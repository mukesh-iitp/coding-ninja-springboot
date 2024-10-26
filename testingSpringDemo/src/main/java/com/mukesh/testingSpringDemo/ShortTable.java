package com.mukesh.testingSpringDemo;

public class ShortTable implements Table {
	
	double height;
	double length;
	
	public ShortTable() {
		this.height = 15.5;
		this.length = 25.5;
	}
	
	@Override
	public String showDetails() {
		// TODO Auto-generated method stub
		return "the table has height "+this.height+" and length "+this.length;
	}

}
