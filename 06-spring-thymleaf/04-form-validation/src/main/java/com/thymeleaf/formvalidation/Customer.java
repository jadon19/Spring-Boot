package com.thymeleaf.formvalidation;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[a-zA-Z]{5}",message = "at least 5 is required")
    @Size(min = 5)
    private String lastName;

    @NotNull(message = "cannot be null")
    @Min(value = 18)
    private Integer age;


    @CourseCode(value = "USR",message = "goddammiititt")
    private String courseCode;


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
