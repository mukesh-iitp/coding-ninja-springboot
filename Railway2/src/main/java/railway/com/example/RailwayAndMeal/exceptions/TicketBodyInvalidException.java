package railway.com.example.RailwayAndMeal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TicketBodyInvalidException extends RuntimeException{

	public TicketBodyInvalidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
