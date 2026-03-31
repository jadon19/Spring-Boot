package com.hibernate.cruddemo.repository;

import com.hibernate.cruddemo.dao.StudentDAO;
import com.hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Student findById(Integer id){
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        //create a query
        //get all the student objects
        TypedQuery<Student> query =  em.createQuery("SELECT s FROM Student s",Student.class);
        return  query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String name){
        //create a query
        //get all the student objects
        TypedQuery<Student> query =  em.createQuery("SELECT s FROM Student s where lastName = :name",Student.class);
        query.setParameter("name" , name);
        return  query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student){
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer i){
        Student student = em.find(Student.class,i);
        em.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll(){
        return em.createQuery("DELETE FROM Student").executeUpdate();
    }
}






