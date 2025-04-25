package com.aithinkers.dao;

import java.util.List;

import com.aithinkers.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
	
	void Update(Student stud);
	
	void delete(Integer id);
	
	Integer deleteAll();

}
