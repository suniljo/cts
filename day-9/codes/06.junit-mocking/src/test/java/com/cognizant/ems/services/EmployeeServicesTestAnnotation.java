package com.cognizant.ems.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.ems.dao.EmployeeDAO;
import com.cognizant.ems.services.impl.EmployeeServicesImpl;

/*
 * @Mock creates a mock. 
 * @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy ) annotations into this
 * @InjectMocks creates the object under test and tries to inject the available mocks into it.
 */

//1. extend the test with MockitoExtension - dependency: mockito-junit-jupiter
@ExtendWith(MockitoExtension.class)
class EmployeeServicesTestAnnotation {
	
	// 2. create the dependency mock
	@Mock
	private EmployeeDAO empMockDao;
	
	// 3. automatically inject the mock into this class
	@InjectMocks
	static EmployeeServicesImpl empServices;
	
	@Test
	void testGetEmployeeNameById() {
		//define behavior for the mock
		Mockito.when(empMockDao.findEmployeeNameById(101)).thenReturn("Sanjay");
		Mockito.when(empMockDao.findEmployeeNameById(102)).thenReturn(null);

		// test the service
		int empId = 101;
		String expectedName = "Sanjay";
		
		String actualName = empServices.getEmployeeNameById(empId);
		assertEquals(expectedName, actualName);
		
		assertNull(empServices.getEmployeeNameById(102));		
	}

}
