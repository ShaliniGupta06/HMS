package com.amdocs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.exception.PatientNotFoundException;
import com.amdocs.model.Patient;
import com.amdocs.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
	
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List <Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    @GetMapping("/patients/{id}")
    public ResponseEntity < Patient > getPatientById(@PathVariable(value = "id") Long patientId)
    throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new PatientNotFoundException("Patient not found for this id :: " + patientId));
        return ResponseEntity.ok().body(patient);
    }
    
    @DeleteMapping("/patients/{id}")
    public Map < String, Boolean > deletePatient(@PathVariable(value = "id") Long patientId)
    throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new PatientNotFoundException("Patient not found for this id :: " + patientId));

        patientRepository.delete(patient);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}