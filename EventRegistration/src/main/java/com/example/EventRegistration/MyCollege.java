package com.example.EventRegistration;

public class MyCollege implements College {
	
	String name = "College Name";
	CollegeEvent collegeEvent;
	
	public void setCollegeEvent(CollegeEvent event) {
		this.collegeEvent = event;
	}

	@Override
	public String getCollegeName() {
		return this.name;
	}

	@Override
	public CollegeEvent getCollegeEvent() {
		return collegeEvent;
	}

}
