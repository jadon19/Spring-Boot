package com.restapi.student.crud.controller;


import com.restapi.student.crud.entity.Student;
import com.restapi.student.crud.exception.StudentErrorResponse;
import com.restapi.student.crud.exception.StudentNotFound;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {


    private List<Student> students;
    @PostConstruct
//    This only runs once
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("tanishka","jadon"));
        students.add(new Student("priya","jadon"));
        students.add(new Student("deepali","singh"));
        students.add(new Student("sadhna","singh"));
        students.add(new Student("rampratap","singh"));
    }



    @GetMapping("/students")
    public List<Student> displayStudents(){
        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) throws StudentNotFound{
        if(studentId >= students.size() || studentId<0){
//            have to throw an exception object of your custom exception
            throw new StudentNotFound("Student Id Not Found : " +studentId);
        }
        return students.get(studentId);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFound e){
//        handle the thrown exception
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }

}
