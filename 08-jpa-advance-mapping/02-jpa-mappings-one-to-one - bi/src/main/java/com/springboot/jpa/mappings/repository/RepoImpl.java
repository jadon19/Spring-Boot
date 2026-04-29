package com.springboot.jpa.mappings.repository;

import com.springboot.jpa.mappings.entity.StudentDetails;
import com.springboot.jpa.mappings.entity.Students;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepoImpl implements RepoInterface{
    private EntityManager em;
    @Autowired
    public RepoImpl(EntityManager em){
        this.em = em;
    }
    @Override
    @Transactional
    public void save(Students student) {
        em.persist(student);
    }

    @Override
    public Students findById(int id) {
        return em.find(Students.class,id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Students tempStudent = em.find(Students.class,id);
        em.remove(tempStudent);
    }

    @Override
    @Transactional
    public void saveStudentDetail(StudentDetails studentDetails) {
        em.persist(studentDetails);
    }

    @Override
    public StudentDetails findStudentDetailById(int id) {
        return em.find(StudentDetails.class,id);
    }

    @Override
    @Transactional
    public void deleteStudentDetailsById(int id) {
        em.remove(em.find(StudentDetails.class,id));
    }


}
