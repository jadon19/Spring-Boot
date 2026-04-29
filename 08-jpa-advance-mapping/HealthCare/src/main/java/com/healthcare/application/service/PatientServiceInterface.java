package com.healthcare.application.service;

import com.healthcare.application.entity.Patient;

import java.util.List;

public interface PatientServiceInterface {
    Patient findPatientById(int id);
}
