package com.aithinkers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aithinkers.entity.Student;

import jakarta.persistence.EntityManager;
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

}
