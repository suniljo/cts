package com.cognizant.ems.services;

import java.util.List;

public interface EmployeeServices {
	public String getEmployeeNameById(int eid);
	
	public List<String> findAllNames();
}
