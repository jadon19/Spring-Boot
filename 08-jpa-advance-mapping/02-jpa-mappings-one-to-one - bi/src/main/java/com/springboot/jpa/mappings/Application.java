package com.springboot.jpa.mappings;

import com.springboot.jpa.mappings.entity.StudentDetails;
import com.springboot.jpa.mappings.entity.Students;
import com.springboot.jpa.mappings.repository.RepoInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	@Bean
	public CommandLineRunner cmdlr(RepoInterface repo){
		return runner->{
//			createStudent(repo);
//			findStudentById(repo);
			deleteStudentById(repo);
		};
	}



	private void createStudent(RepoInterface repo) {
		Students student = new Students("tanishka");
		StudentDetails student_detail = new StudentDetails("tanishkajadon19@gmail.com","female","cse",8.9f);

//		two ways one-to-one relationship
		student.setStudentDetails(student_detail);
		student_detail.setStudent(student);


		repo.saveStudentDetail(student_detail);
	}

	private void findStudentById(RepoInterface repo) {
		System.out.println("Finding Student by id = 4");
		StudentDetails tempStudent = repo.findStudentDetailById(4);
		System.out.println("Student information : "+tempStudent);

	}
	private void deleteStudentById(RepoInterface repo) {
		System.out.println("Deleting Student with ID: 4");
		repo.deleteStudentDetailsById(4);
	}

}
