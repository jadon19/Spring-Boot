package com.hibernate.cruddemo;

import com.hibernate.cruddemo.dao.StudentDAO;
import com.hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentdao){
		return runner->{
//			To create a single student using persist() method of Entity Manager
//			createStudent(studentdao);

//			To create multiple users and save
			createMultipleStudents(studentdao);


//			retrieve student using find method of EM
			retrieveStudent(studentdao);


//			Retrieve all the students by executing a TypedQuery object
//			getAllStudents(studentdao);



//			Using Dynamic TypedQuery
//			System.out.println("Enter a last name : ");
//			Scanner obj = new Scanner(System.in);
//			String data = obj.next();
//			getStudentByLastName(studentdao,data);


//			Update Student First name. Note: use dynamic query to make it work for any set name and id + handle dirty check (refresh Persistent Context)
//			updateStudentFirstName(studentdao);

//			Delete a student
//			deleteStudent(studentdao,4);

//			Delete all students using query
//			deleteAllStudent(studentdao);

		};
	}



	private void createStudent(StudentDAO studentdao) {
		System.out.println("Creating student object");
		Student tempStudent = new Student("tanishka","jadon","tanishkajaodn19@gmail.com");
		studentdao.save(tempStudent);
		System.out.println("generated student id : "+tempStudent.getId());
	}
	private void createMultipleStudents(StudentDAO studentdao) {
		System.out.println("Creating student object");
		Student tempStudent1 = new Student("sadhna","singh","sadhnasinghhm8909@gmail.com");
		Student tempStudent2 = new Student("deepali","singh","deep364@gmail.com");
		Student tempStudent3 = new Student("priya","jadon","pri.jadon@gmail.com");
		studentdao.save(tempStudent1);
		studentdao.save(tempStudent2);
		studentdao.save(tempStudent3);
		System.out.println("generated student id : "+tempStudent1.getId());
		System.out.println("generated student id : "+tempStudent2.getId());
		System.out.println("generated student id : "+tempStudent3.getId());
	}

	public void retrieveStudent(StudentDAO studentdao){
		System.out.println("reading student...");
		Student tempStudent1 = new Student("rampratap","singh","rpsingh8980@gmail.com");
		studentdao.save(tempStudent1);
		System.out.println("saved student with id type int: "+tempStudent1.getId());
		Student mystudent = studentdao.findById(tempStudent1.getId());
		System.out.println(mystudent);
	}

	public void getAllStudents(StudentDAO studentDAO){
		List<Student> students= studentDAO.findAll();
		for (Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}
	public void getStudentByLastName(StudentDAO studentDAO,String name){
		List<Student> students = studentDAO.findByLastName(name);
		for (Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}

	public void updateStudentFirstName(StudentDAO studentdao){
		int studentId = 1;
		System.out.println("getting student with ID : " + studentId);
		Student student = studentdao.findById(studentId);
		System.out.println("Student record  : "+student);

		System.out.println("Changing First name of student...");
		student.setFirstName("Potato");

		studentdao.update(student);
		System.out.println("Updated student is : "+student);
	}
	public void deleteStudent(StudentDAO studentdao,Integer i){
		studentdao.delete(i);
	}
	public void deleteAllStudent (StudentDAO studentDAO){
		int rows = studentDAO.deleteAll();
		System.out.println("Number of rows affected : "+rows );
	}
}
