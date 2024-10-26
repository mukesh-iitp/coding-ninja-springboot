package com.example.ReadWell;

public interface Book {
	
	String getBookName();
	void setBookName(String name);
	boolean isIssued();
	void issue();
}
