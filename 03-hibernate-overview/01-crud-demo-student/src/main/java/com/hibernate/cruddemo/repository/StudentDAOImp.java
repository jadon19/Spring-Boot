package com.hibernate.cruddemo.repository;

import com.hibernate.cruddemo.dao.StudentDAO;
import com.hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImp implements StudentDAO {
//    define field for entity manager
//    inject entity manager using constructor

    private EntityManager em;

    @Autowired
    public StudentDAOImp(EntityManager em){
        this.em = em;

    }
    @Override
    @Transactional
    public void save(Student student){
        em.persist(student);
    }
}






