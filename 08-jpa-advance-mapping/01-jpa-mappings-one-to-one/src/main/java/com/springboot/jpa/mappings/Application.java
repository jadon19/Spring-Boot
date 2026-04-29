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

	private void deleteStudentById(RepoInterface repo) {
		System.out.println("Deleting Student with ID: 1");
		repo.deleteById(1);
	}

	private void findStudentById(RepoInterface repo) {
		System.out.println("Finding Student by id = 1");
		Students tempStudent = repo.findById(1);
		System.out.println("Student information : "+tempStudent);
		System.out.println("Student details : "+tempStudent.getStudentDetails());

	}

	private void createStudent(RepoInterface repo) {
		Students student = new Students("tanishka");
		StudentDetails student_detail = new StudentDetails("tanishkajadon19@gmail.com","female","cse",8.9f);
		student.setStudentDetails(student_detail);
		repo.save(student);


		Students student_2 = new Students("priya");
		StudentDetails student_detail_2 = new StudentDetails("pri.ds@gmail.com","female","eee",9.5f);
		student_2.setStudentDetails(student_detail_2);
		repo.save(student_2);

	}


}
