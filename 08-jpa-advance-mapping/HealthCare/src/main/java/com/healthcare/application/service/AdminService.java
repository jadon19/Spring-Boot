package com.healthcare.application.service;

import com.healthcare.application.entity.Patient;
import com.healthcare.application.reposiotry.PatientRepository;
import com.healthcare.application.reposiotry.PatientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements AdminServiceInterface{
    private PatientRepository patientRepository;
    @Autowired
    public AdminService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
