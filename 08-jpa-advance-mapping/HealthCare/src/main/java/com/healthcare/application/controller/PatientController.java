package com.healthcare.application.controller;

import com.healthcare.application.entity.Patient;
import com.healthcare.application.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @GetMapping("/dashboard/{id}")
    public Patient navigateToDashboard(@PathVariable int id){
        System.out.println(patientService.findPatientById(id));
        return patientService.findPatientById(id);
    }
}
