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

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	/**
	 * 
	 *  • API GET "/doctor/{id}" (@PathVariable Long id): Retrieves a Doctor for the given id.

        • API POST "/doctor/add/{patientId}" (@PathVariable Long patientId, Body Doctor doctor): Creates a new Doctor for the given patientId.

        • API PUT "/doctor/update" (Body Doctor doctor): Updates an existing Doctor with the data provided in the request body.

        • API DELETE "/doctor/delete/{id}" (@PathVariable Long id): Deletes a doctor for the given id.
	 */
	
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/{id}")
	public Doctor getDoctorById(@PathVariable Long id) {
		return doctorService.getDoctorById(id);
	}
	
	@PostMapping("/add/{patientId}")
	public Doctor createDoctorForPatient(@PathVariable Long patientId, @RequestBody Doctor doctor) {
		return doctorService.createDoctorForPatient(patientId, doctor);
	}
	
	@PutMapping("/update")
	public Doctor updateDoctor(@RequestBody Doctor updatedDoctor) {
		return doctorService.updateDoctor(updatedDoctor);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteDoctorById(@PathVariable Long id) {
		doctorService.deleteDoctorById(id);
	}

}
