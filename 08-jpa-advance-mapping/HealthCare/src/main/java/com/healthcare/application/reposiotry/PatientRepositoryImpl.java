package com.healthcare.application.reposiotry;

import com.healthcare.application.entity.Patient;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryImpl implements PatientRepository{
    private EntityManager em;
    @Autowired
    public PatientRepositoryImpl(EntityManager em){
        this.em=em;
    }
    @Override
    public Patient findPatientById(int id) {
        return em.find(Patient.class,id);
    }

    @Override
    public List<Patient> findAll() {
        TypedQuery<Patient> query = em.createQuery("Select p FROM PATIENT p",Patient.class);
        return query.getResultList();
    }
}
