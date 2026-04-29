package com.healthcare.application.service;

import com.healthcare.application.entity.Patient;
import com.healthcare.application.reposiotry.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements PatientServiceInterface{

    private PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository pr){
        this.patientRepository = pr;
    }

    @Override
    public Patient findPatientById(int id) {
        return patientRepository.findPatientById(id);
    }

}
