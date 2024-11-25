package com.CN.Gym.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GymNotFoundException extends RuntimeException {


    /*
        Extend the class with RuntimeException and create a constructor with
        (String message) as argument in order to handle custom exception message.
    */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GymNotFoundException(String message) {
		super(message);
	}

	

}
