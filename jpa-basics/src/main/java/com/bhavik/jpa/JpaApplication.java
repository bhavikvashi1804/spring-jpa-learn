package com.bhavik.jpa;

import com.bhavik.jpa.entity.Course;
import com.bhavik.jpa.entity.Passport;
import com.bhavik.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {


		Passport passport = new Passport("T001");
		Student student = new Student("Bhavik");
		student.setPassport(passport);
		entityManager.persist(student);

	}
}
