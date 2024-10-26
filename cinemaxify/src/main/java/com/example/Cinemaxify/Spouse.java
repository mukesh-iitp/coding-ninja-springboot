package com.example.Cinemaxify;

// Override the User Interface methods in Spouse class
public class Spouse implements User{
    private String name;
    private String memberName = "spouse";
    private int age;
    private Long contact;
    private String address;
    private Plan plan;
    
//    public Spouse(Plan plan) {
//    	this.plan = plan;
//    }
    
    public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public void setUserDetails(String name, int age, Long contact, String address) {
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.address = address;
	}
    
    @Override
	public Plan getUserPlan() {
		return plan;
	}
    
	@Override
	public void getUserDetails() {
		System.out.println("Hello "+this.name+" you have entered the following details:");
		System.out.println("age: "+this.age);
		System.out.println("contact: "+this.contact);
		System.out.println("address: "+this.address);
		System.out.println("You have selected a"+ plan.getPlanName() + "plan for "+this.memberName);
	}


}
