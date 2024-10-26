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

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	/*
	 * • API GET "/patient/{id}" (@PathVariable Long id): Retrieves a patient for the given id.

        • API POST "/patient/add" (Body Patient patient): Creates a new patient.

        • API PUT "/patient/update" (Body Patient patient): Updates an existing patient.

        • API DELETE "/patient/delete/{id}" (@PathVariable Long id): Deletes a specific patient by ID.
	 */
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}
	
	@PostMapping("/add")
	public Patient createPatient(@RequestBody Patient newPatient) {
		return patientService.savePatient(newPatient);
	}
	
	@PutMapping("/update")
	public Patient updatePatient(@RequestBody Patient updatedPatient) {
		return patientService.udpatePatient(updatedPatient);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePatientById(@PathVariable Long id) {
		patientService.deletePatientById(id);
	}

}
