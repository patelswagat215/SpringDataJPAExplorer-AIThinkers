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
		Student joe=new Student("Joe","Patel","joe215@gmail.com");
		Student john=new Student("John","Patel","john@gmail.com");
		Student harry=new Student("Harry","Patel","harry@gmail.com");
		Student mark=new Student("Mark","Patel","mark@gmail.com");
		
		//Save the student object
		System.out.println("Saving the student");
		studentDAO.save(joe);
		studentDAO.save(john);
		studentDAO.save(harry);
		studentDAO.save(mark);
		
		//dislay id of the saved student
		System.out.println("Saved the students");
		
		
	}
}
