package com.example.patient_management_1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.AddressRepository;
import com.example.patient_management_1.repository.PatientRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	PatientRepository patientRepository;

	public Address getAddressById(Long id) {
		//return addressRepository.findById(id).get();
		Optional<Address> address = addressRepository.findById(id);
		return address.orElse(null);
	}

	public Address addAddressForPatient(Long patientId,Address newAddress) {
		Patient patient = patientRepository.findById(patientId).get();
		Address saveAddress = addressRepository.save(newAddress);
		patient.setAddress(saveAddress);
		patientRepository.save(patient);
		return saveAddress;
	}

	public Address updateAddress(Address updatedAddress) {
		return addressRepository.save(updatedAddress);
	}

	public void deleteAddressById(Long id) {
		for(Patient patient : patientRepository.findAll()) {
			if(patient.getAddress()!=null && patient.getAddress().getId().equals(id)) {
				patient.setAddress(null);
				patientRepository.save(patient);
				addressRepository.deleteById(id);
			}
		}
		
	}
	
	

}
