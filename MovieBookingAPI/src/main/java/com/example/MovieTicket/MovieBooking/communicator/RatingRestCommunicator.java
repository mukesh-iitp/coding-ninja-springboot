package com.example.MovieTicket.MovieBooking.communicator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;

@Service
public class RatingRestCommunicator {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public RatingRestCommunicator(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public long getRating(String id) {
		String url = "http://localhost:8081/rating/id/";
		//return restTemplate.exchange(url+id, HttpMethod.GET, null, Long.class).getBody();
		 Long ratingResponse = restTemplate.getForObject(url+id, Long.class);
		 
		 return ratingResponse;

	}
	
	public void addRating(Map< String,Long > ratingsMap) {
		String url = "http://localhost:8081/rating/add";
		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingsMap);
		restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class );
		
	}
	
	public void updateRating(Map< String, Long > ratingsMap) {
		String url = "http://localhost:8081/rating/update";
		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingsMap);
		restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class );
		
	}
	
	public void deleteRating(String id) {
		String url = "http://localhost:8081/rating/id/";
		try {
			restTemplate.exchange(url+id, HttpMethod.DELETE, null , Object.class );
		}catch(IdNotFound e) {
			throw new IdNotFound(" Error " + HttpStatus.NOT_FOUND.toString());
		}
		
	}
		
	
}
