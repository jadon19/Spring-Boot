package com.healthcare.application.entity;

import com.healthcare.application.enums.BloodGroupType;
import jakarta.persistence.*;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.mapping.PrimaryKey;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name="patients"
, uniqueConstraints = {
        @UniqueConstraint(name="email_unique", columnNames = {"name","email"})
})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name="birth_date",nullable = false)
    private LocalDate dob;

    @Column(name="email" ,nullable = false)
    private String email;

    @Column(name="created_at", nullable = false)
    private Timestamp createdAt;


    @Enumerated(EnumType.STRING)
    @Column(name="blood_group")
    private BloodGroupType bloodGroup;

    public Patient() {
    }

    public Patient(String name, String gender, LocalDate dob, String email) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public BloodGroupType getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroupType bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
