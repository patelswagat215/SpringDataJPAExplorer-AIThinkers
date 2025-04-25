package com.aithinkers;

import java.util.List;

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
			// createStudent(studentDAO);
			CreateAndRetrieveStudnt(studentDAO);
			//retrieveAllStudents(studentDAO);
			//retrieveByLastName(studentDAO);
			//updateById(studentDAO);
			//deleteById(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.print("Records are deleting....");
		Integer deletCount = studentDAO.deleteAll();
		System.out.print("Records are deleted.... "+deletCount+" Rows are affected");
		
	}

	private void deleteById(StudentDAO studentDAO) {
		//Deleting record
		studentDAO.delete(3);
		
	}

	private void updateById(StudentDAO studentDAO) {
		//Find Record By ID
		Student student=studentDAO.findById(1);
		
		//Modify the name
		student.setFirstName("Scooby");
		
		//Update the student
		studentDAO.Update(student);
		
		//Show the updated record
		System.out.println("New Record Is :-"+student);
		
	}

	private void retrieveByLastName(StudentDAO studentDAO) {
		
		List<Student> studs=studentDAO.findByLastName("Patel");
		
		studs.forEach(stud->System.out.println(stud));
	        
		
	}

	private void retrieveAllStudents(StudentDAO studentDAO) {
		//Fetch all students
		System.out.println("Fetching all  students");
		List<Student> allStuds = studentDAO.findAll();
		
		//Display List of students
		System.out.println("Displaying all  students");
		allStuds.stream().forEach(studs->System.out.println(studs));
	}

	private void CreateAndRetrieveStudnt(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating student object");
		Student joe = new Student("Joe", "Patel", "joe215@gmail.com");

		// Save the student object
		System.out.println("Saving the student");
		studentDAO.save(joe);

		// Find record by ID
		System.out.println("Getting the student");
		Student stud = studentDAO.findById(joe.getId());

		System.out.println(stud);

	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating student object");
		Student joe = new Student("Joe", "Patel", "joe215@gmail.com");
		Student john = new Student("John", "Patel", "john@gmail.com");
		Student harry = new Student("Harry", "Patel", "harry@gmail.com");
		Student mark = new Student("Mark", "Patel", "mark@gmail.com");

		// Save the student object
		System.out.println("Saving the student");
		studentDAO.save(joe);
		studentDAO.save(john);
		studentDAO.save(harry);
		studentDAO.save(mark);

		// dislay id of the saved student
		System.out.println("Saved the students");

	}
}
