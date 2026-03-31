package com.hibernate.cruddemo;

import com.hibernate.cruddemo.dao.StudentDAO;
import com.hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentdao){
		return runner->{
			createStudent(studentdao);
		};
	}

	private void createStudent(StudentDAO studentdao) {
		System.out.println("Creating student object");
		Student tempStudent = new Student("tanishka","jadon","tanishkajaodn19@gmail.com");
		studentdao.save(tempStudent);
		System.out.println("generated student id : "+tempStudent.getId());
	}
}
