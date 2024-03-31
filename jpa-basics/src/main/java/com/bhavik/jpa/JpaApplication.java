package com.bhavik.jpa;

import com.bhavik.jpa.entity.Course;
import com.bhavik.jpa.entity.Passport;
import com.bhavik.jpa.entity.Student;
import com.bhavik.jpa.inh.entity.Employee;
import com.bhavik.jpa.inh.entity.FullTimeEmployee;
import com.bhavik.jpa.inh.entity.PartTimeEmployee;
import com.bhavik.jpa.repo.EmployeeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {


		Employee employee1 = new FullTimeEmployee("Bhavik", 20000L);
		Employee employee2 = new PartTimeEmployee("Raj", 20L);

		employeeRepo.storeEmployee(employee1);
		employeeRepo.storeEmployee(employee2);

		List<Employee> employeeList = employeeRepo.getAllEmployees();

		System.out.println(employeeList);
	}
}
