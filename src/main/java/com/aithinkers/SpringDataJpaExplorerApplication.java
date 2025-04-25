package com.aithinkers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aithinkers.dao.StudentDAO;
import com.aithinkers.entity.Student;

@SpringBootApplication
public class SpringDataJpaExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExplorerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandlinerunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating student object");
		Student tempStudent=new Student("Swagat","Patel","patelswagat215@gmail.com");
		
		//Save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		
		//dislay id of the saved student
		System.out.println("Saved the student,Generated ID:-"+tempStudent.getId());
		
		
	}
}
