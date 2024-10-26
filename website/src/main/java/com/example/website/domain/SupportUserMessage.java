package com.example.website.domain;

import org.springframework.stereotype.Component;

@Component
public class SupportUserMessage implements UserMessage {
	
	String message;
	

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public void setUserID(int userID) {
		this.message = "Hi welcome to support "+String.valueOf(userID);
		
	}

}
