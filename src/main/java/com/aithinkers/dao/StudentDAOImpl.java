package com.aithinkers.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aithinkers.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// Define field for EntityManager
	private EntityManager entityManager;

	// Inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);

	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
		
	}

	@Override
	public List<Student> findAll() {
		
		//Crate query
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by firstName desc",Student.class);
		
		//Return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		//Crate query
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student where lastName=lastName",Student.class);
		
		//Return query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void Update(Student stud) {
		entityManager.merge(stud);
		
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		//Retrieve the student
		Student stud=entityManager.find(Student.class,id);
		
		//Delete student
		entityManager.remove(stud);
		
	}

	@Override
	@Transactional
	public Integer deleteAll() {
		int executeUpdateCount = entityManager.createQuery("Delete FROM Student").executeUpdate();
		return executeUpdateCount;
	}

}
