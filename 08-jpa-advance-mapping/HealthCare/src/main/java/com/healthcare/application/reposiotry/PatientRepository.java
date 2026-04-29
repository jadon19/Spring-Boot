package com.healthcare.application.reposiotry;
import com.healthcare.application.entity.Patient;

import java.util.List;

public interface PatientRepository {
    Patient findPatientById(int id);
    List<Patient> findAll();
}
