package com.example.patient_management_1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	public Patient getPatientById(Long id) {
		//Patient patient = patientRepository.findById(id).get();
		Optional<Patient> optionalPatient = patientRepository.findById(id);
		return optionalPatient.orElse(null);
	}

	public Patient savePatient(Patient newPatient) {
		return patientRepository.save(newPatient);

	}

	public Patient udpatePatient(Patient updatedPatient) {
		if(patientRepository.existsById(updatedPatient.getId()))
			return patientRepository.save(updatedPatient);
		else
			return null;	
	}

	public void deletePatientById(Long id) {
		if (patientRepository.existsById(id))
			patientRepository.deleteById(id);
	}



}
