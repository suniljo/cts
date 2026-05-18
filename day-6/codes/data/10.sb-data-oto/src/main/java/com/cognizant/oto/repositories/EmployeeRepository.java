package com.cognizant.oto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.oto.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
