package com.example.hotel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.hotel.communicator.RatingServiceCommunicator;
import com.example.hotel.exceptions.HotelIdAlreadyExist;
import com.example.hotel.exceptions.HotelNotFoundException;
import com.example.hotel.model.Hotel;

@Service
public class HotelService {
	
	List<Hotel> hotelList = new ArrayList<Hotel>();
	Map<String, Hotel> hotelMap = new HashMap<String, Hotel>();
	
	@Autowired
	RatingServiceCommunicator ratingServiceCommunicator;
	
	public void createHotel(Hotel hotel) {
		
		if(hotelMap.containsKey(hotel.getId())) {
			throw new HotelIdAlreadyExist("Hotel ID already exist");
		}
		
		Map<String, Long> ratingMap = new HashMap<String, Long>(); 
		
		hotelList.add(hotel);
		hotelMap.put(hotel.getId(), hotel);
		ratingMap.put(hotel.getId(), hotel.getRating());
		ratingServiceCommunicator.addRating(ratingMap);
	}


	public Hotel getHotelById(String hotelId) {
		if(ObjectUtils.isEmpty(hotelMap.get(hotelId))) {
			throw new HotelNotFoundException("Hotel not found for id: "+hotelId);
		}
		
		Hotel hotel = hotelMap.get(hotelId);
		//Rest services steps to fetch the rating by id.
		//We will be using rest templates
		long updatedRating = ratingServiceCommunicator.getRating(hotelId);
		hotel.setRating(updatedRating);
		
		return hotel;	
	}


	public List<Hotel> getAllHotels() {
		return hotelList;
	}


	public void deleteHotelById(String hotelId) {
		hotelList.remove(getHotelById(hotelId));
		hotelMap.remove(hotelId);
		
		ratingServiceCommunicator.deleteRating(hotelId);
	}


	public void updateHotel(Hotel updatedHotel) {
		//1. get the previous hotel data
		Hotel existingHotel = getHotelById(updatedHotel.getId());
		
		//2. remove this old data from the list
		hotelList.remove(existingHotel);
				
		//3. add the updated data to the list
		hotelList.add(updatedHotel);
		
		//4. update the previous data with new data in map
		//5. update the new data in map
		hotelMap.put(updatedHotel.getId(), updatedHotel);
		
		Map<String, Long> updateRating = new HashMap<String, Long>();
		updateRating.put(updatedHotel.getId(), updatedHotel.getRating());
		ratingServiceCommunicator.updateRating(updateRating);
		
	}
	

}
