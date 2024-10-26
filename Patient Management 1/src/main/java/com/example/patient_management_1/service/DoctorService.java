package com.example.patient_management_1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.DoctorRepository;
import com.example.patient_management_1.repository.PatientRepository;


@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;

	public Doctor getDoctorById(Long id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		return doctor.orElse(null);
	}

	public Doctor createDoctorForPatient(Long patientId, Doctor doctor) {
		Patient patient = patientRepository.findById(patientId).get();
		Doctor savedDoctor = doctorRepository.save(doctor);
		patient.setDoctor(savedDoctor);
		patientRepository.save(patient);
		return doctor;
	}

	public Doctor updateDoctor(Doctor updatedDoctor) {
		return doctorRepository.save(updatedDoctor);
	}

	public void deleteDoctorById(Long id) {
		for(Patient patient : patientRepository.findAll()){
			if(patient.getDoctor()!=null && patient.getDoctor().getId().equals(id)) {
				patient.setDoctor(null);
				patientRepository.save(patient);
				doctorRepository.deleteById(id);
			}
		}
	}

}
