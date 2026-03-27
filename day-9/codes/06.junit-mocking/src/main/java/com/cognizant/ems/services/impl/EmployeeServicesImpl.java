package com.cognizant.ems.services.impl;

import java.util.List;

import com.cognizant.ems.dao.EmployeeDAO;
import com.cognizant.ems.services.EmployeeServices;

public class EmployeeServicesImpl implements EmployeeServices {
	private EmployeeDAO empDao;
	
	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	public String getEmployeeNameById(int eid) {
		// accessing DAO layer business logic
		String empName = empDao.findEmployeeNameById(eid);

		return empName;
	}

	@Override
	public List<String> findAllNames() {
		List<String> empNames = empDao.findEmployeeNames();
		if(empNames.isEmpty())
			return null;
		
		return empNames;
	}

}
