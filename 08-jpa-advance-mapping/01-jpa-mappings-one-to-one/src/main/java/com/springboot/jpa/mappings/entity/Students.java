package com.springboot.jpa.mappings.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usn_id")
    private int usn;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "student_detail_id")
    private StudentDetails studentDetails;

    public Students(){

    }

    public Students(String name) {
        this.name = name;
    }

    public int getUsn() {
        return usn;
    }

    public void setUsn(int usn) {
        this.usn = usn;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "usn=" + usn +
                ", name='" + name + '\'' +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
