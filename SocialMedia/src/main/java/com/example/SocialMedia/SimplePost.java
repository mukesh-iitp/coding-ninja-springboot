package com.example.SocialMedia;

public class SimplePost implements Post {
	
	String message;
	
	public void destroy() {
		System.out.println("Post detroyed");
	}

	@Override
	public void setMessage(String message) {
		this.message = message;

	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
