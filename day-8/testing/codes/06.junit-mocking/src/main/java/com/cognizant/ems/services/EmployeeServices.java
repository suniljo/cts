package com.cognizant.ems.services;

import com.cognizant.ems.dao.EmployeeDAO;

public class EmployeeServices {
	EmployeeDAO empDao;
	
	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	public String getEmployeeNameById(int eid) {
		String ename = empDao.findEmployeeNameById(eid);

		return ename;
	}
}
