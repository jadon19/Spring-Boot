package com.springboot.thymeleaf;

public class Employee {

    private String name;
    private String dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public Employee() {}

    public Employee(int id,String name, String dept) {
        this.name = name;
        this.dept = dept;
        this.id=id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }
}