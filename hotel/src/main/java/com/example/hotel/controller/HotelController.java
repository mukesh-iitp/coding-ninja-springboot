package com.example.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.exceptions.BadRequestException;
import com.example.hotel.model.Hotel;
import com.example.hotel.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping("/create")
	public void creatHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new BadRequestException("Request not valid");
		}
		hotelService.createHotel(hotel);
	}
	
	@GetMapping("/id/{hotelId}")
	public Hotel getHotelById(@PathVariable String hotelId) {
		return hotelService.getHotelById(hotelId);
	}
	
	@GetMapping("/getAll")
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}
	
	@DeleteMapping("/remove/id/{hotelId}")
	public void deleteHotelById(@PathVariable String hotelId) {
		hotelService.deleteHotelById(hotelId);
	}
	
	@PutMapping("/update")
	public void updateHotel(@RequestBody Hotel updatedHotel) {
		hotelService.updateHotel(updatedHotel);
	}
	
//	@PutMapping("/update/{hotelId}")
//	public void updateHotelByID(@PathVariable String hotelId, @RequestBody Hotel updatedHotel) {
//		hotelService.updateHotelByID(hotelId, updatedHotel);
//	}

}
