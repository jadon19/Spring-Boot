package com.spring.security.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int departmentId;

    @Column(name = "dept_name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<EmployeeDetails> employees;

    public Department() {
    }

    public void addEmployee(EmployeeDetails emp) {
        employees.add(emp);
        emp.setDepartment(this);
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<EmployeeDetails> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDetails> employees) {
        this.employees = employees;
    }
}