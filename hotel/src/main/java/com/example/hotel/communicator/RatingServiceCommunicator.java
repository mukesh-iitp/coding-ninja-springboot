package com.example.hotel.communicator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.hotel.exceptions.HttpRatingServiceNotFound;

@Service
public class RatingServiceCommunicator {
	
	//this will have the rest template
	
	//creating rest template
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	//interacting with rating service
	public long getRating(String id) {
		String url = "http://localhost:8081/rating/id/";
		
		//ResponseEntity<Long> response = restTemplate.getForEntity(url+id, Long.class);
		//long ratingResponse = restTemplate.getForObject(url+id, Long.class);
				
		//return response.getBody();
		//return ratingResponse;
		return restTemplate.exchange(url+id, HttpMethod.GET, null, Long.class ).getBody();	
	}

	public void addRating(Map<String, Long> ratingMap) {
		String url = "http://localhost:8081/rating/add";
		//restTemplate.postForEntity(url, ratingMap, Object.class);
		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingMap);
		restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class );

	}
	
	public void updateRating(Map<String, Long> ratingMap) {
		String url = "http://localhost:8081/rating/update";
		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingMap);
		restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class );
	}
	
	
	public void deleteRating(String id) {
		String url = "http://localhost:8081/rating/remove/id/";
		//HttpEntity<String> requestEntity = new HttpEntity<>(ratingMap); not required as there no body 
		
		try {
			restTemplate.exchange(url+id, HttpMethod.DELETE, null , Object.class );
		}catch(HttpClientErrorException e) {
			throw new HttpRatingServiceNotFound(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
			//throw new HttpRatingServiceNotFound(HttpStatusCode.valueOf(404)); //or
		}
		
	}
	
}
