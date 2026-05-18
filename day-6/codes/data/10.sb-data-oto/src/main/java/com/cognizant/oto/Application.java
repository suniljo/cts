package com.cognizant.oto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.oto.entities.Address;
import com.cognizant.oto.entities.Employee;
import com.cognizant.oto.repositories.EmployeeRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*
		Address address = new Address();
		address.setStreet("Ameerpet");
		address.setCity("Hyderabad");
		address.setState("Telangana");
		
		Employee emp = new Employee();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Praveen Kumar");
		emp.setEmployeeAddress(address);
		
		Employee savedEmployee = employeeRepo.save(emp);
		
		System.out.println(savedEmployee);
		*/
		
	
		Employee emp = employeeRepo.findById(101).orElse(null);
		System.out.println(emp.getEmployeeId() + " | " + emp.getEmployeeName());
		System.out.println();
		
		Address addr = emp.getEmployeeAddress();
		System.out.println(addr.getState() + " | " + addr.getCity());
		
		/*
		employeeRepo.deleteById(101);
		*/
	}

}
