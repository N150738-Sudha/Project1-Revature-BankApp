package com.revature.pms.service;

import com.revature.pms.model.Employee;

public interface EmployeeService {
	public int addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean isEmployeeExists(int employeeId);
	public Employee getEmployeeById(int employeeId);
	public boolean permission();

}
