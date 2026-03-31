package com.hibernate.cruddemo.dao;
import java.util.List;
import com.hibernate.cruddemo.entity.Student;
import jakarta.persistence.TypedQuery;

public interface StudentDAO {
//    Create method
    void save(Student student);
//    Read method
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String s);
    void update(Student student);
    void delete(Integer i);
    int deleteAll();
}
