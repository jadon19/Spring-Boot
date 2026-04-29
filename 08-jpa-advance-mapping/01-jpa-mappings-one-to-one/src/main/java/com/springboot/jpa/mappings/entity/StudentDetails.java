package com.springboot.jpa.mappings.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "student_details")
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name="gender")
    private String gender;

    @Column(name="branch")
    private String branch;

    @Column(name="cgpa")
    private float cgpa;


    public StudentDetails() {
    }

    public StudentDetails(String email, String gender, String branch, float cgpa) {
        this.email = email;
        this.gender = gender;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", branch='" + branch + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
