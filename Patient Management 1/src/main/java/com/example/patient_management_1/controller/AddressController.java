package com.example.patient_management_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	/*
	 *  • API GET "/address/{id}" (@PathVariable Long id): retrieves an address with the given id.

        • API POST "/address/add/{patientId}" (@PathVariable Long patientId, Body Address address): creates a new address for the given patientId. 

        • API PUT "/address/update" (Body Address address): updates an existing address.

        • API DELETE "/address/delete/{id}" (@PathVariable Long id): Deletes an address with the given id.
	 */
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	}
	
	@PostMapping("/add/{patientId}")
	public Address addAddressForPatient(@PathVariable Long patientId, @RequestBody Address newAddress) {
		return addressService.addAddressForPatient(patientId,newAddress);
	}
	
	@PutMapping("/update")
	public Address updateAddress(@RequestBody Address updatedAddress) {
		return addressService.updateAddress(updatedAddress);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAddressById(@PathVariable Long id) {
		addressService.deleteAddressById(id);
	}

}
