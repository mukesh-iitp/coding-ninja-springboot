package com.example.ReadWell;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyBook implements Book {

	String name;
	boolean isIssued = false;

	public MyBook(){
		
	}

	public MyBook(String name) {
		this.name = name;
	}

	@Override
	public String getBookName() {
		return this.name;
	}

	@Override
	public void setBookName(String name) {
		this.name = name;
	}

	@Override
	public boolean isIssued() {
		return this.isIssued;
	}

	@Override
	public void issue() {
		this.isIssued = true;
	}

}
