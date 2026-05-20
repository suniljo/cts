package com.cognizant.ems.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cognizant.ems.dao.EmployeeDAO;

class EmployeeServicesTest {

	@Test
	void testGetEmployeeNameById() {
		EmployeeServices empServices = new EmployeeServices();
		
		//create a mock object for EmployeeDAO
		EmployeeDAO mockDao = Mockito.mock(EmployeeDAO.class);
		
		//inject mock object to service component
		empServices.setEmpDao(mockDao);
		
		//--setting the behavior for mock object (stubbing)
		Mockito.when(mockDao.findEmployeeNameById(101)).thenReturn("Sanjay");
		Mockito.when(mockDao.findEmployeeNameById(102)).thenReturn(null);
		
		int eno = 101;
		
		String expectedName = "Sanjay";
		String actualName = empServices.getEmployeeNameById(eno);
		//assertNotNull(actualName);
		assertEquals(expectedName, actualName);
		
		eno = 102;
		String ename = empServices.getEmployeeNameById(eno);
		assertNull(ename);
	}

}
