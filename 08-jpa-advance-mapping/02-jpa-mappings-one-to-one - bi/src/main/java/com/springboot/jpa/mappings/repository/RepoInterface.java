package com.springboot.jpa.mappings.repository;

import com.springboot.jpa.mappings.entity.StudentDetails;
import com.springboot.jpa.mappings.entity.Students;

public interface RepoInterface {
    void save(Students student);
    Students findById(int id);
    void deleteById(int id);
    void saveStudentDetail(StudentDetails studentDetails);
    StudentDetails findStudentDetailById(int id);
    void deleteStudentDetailsById(int id);

}
