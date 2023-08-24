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

import com.amdocs.exception.DoctorNotFoundException;
import com.amdocs.model.Doctor;
import com.amdocs.repository.DoctorRepository;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {
	
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List <Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    @GetMapping("/doctors/{id}")
    public ResponseEntity < Doctor > getDoctorById(@PathVariable(value = "id") Long doctorId)
    throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(() -> new DoctorNotFoundException("Doctor not found for this id :: " + doctorId));
        return ResponseEntity.ok().body(doctor);
    }
    
    @DeleteMapping("/doctors/{id}")
    public Map < String, Boolean > deleteDoctor(@PathVariable(value = "id") Long doctorId)
    throws DoctorNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(() -> new DoctorNotFoundException("Doctor not found for this id :: " + doctorId));

        doctorRepository.delete(doctor);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}