package com.cognizant.ems.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cognizant.ems.dao.EmployeeDAO;
import com.cognizant.ems.services.impl.EmployeeServicesImpl;

class EmployeeServicesTest {
	static EmployeeServicesImpl empService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		empService = new EmployeeServicesImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		empService = null;
	}
	
	@Test
	void testGetEmployeeNameById() {
		//create a mock object for EmployeeDAO
		EmployeeDAO empDaoMock = Mockito.mock(EmployeeDAO.class);
		
		//inject mock object to service component
		empService.setEmpDao(empDaoMock);
		
		//--setting the behaviour for mock object (stubbing)
		Mockito.when(empDaoMock.findEmployeeNameById(101)).thenReturn("Sanjay");
		Mockito.when(empDaoMock.findEmployeeNameById(102)).thenReturn(null);
		
		int empId = 101;
		String expectedName = "Sanjay";
		
		String actualName = empService.getEmployeeNameById(empId);
		assertEquals(expectedName, actualName);
		
		assertNull(empService.getEmployeeNameById(102));
	}

	@Test
	public void testFindAllNames() {
		EmployeeDAO mockObj = Mockito.mock(EmployeeDAO.class);
		empService.setEmpDao(mockObj);
		
		List<String> names = Arrays.asList("Employee-1", "Employee-2");
		Mockito.when(mockObj.findEmployeeNames()).thenReturn(names); 		
		
		List<String> empNames = empService.findAllNames();
		System.out.println(empNames);
		assertNotNull(empNames);
	}	
}
