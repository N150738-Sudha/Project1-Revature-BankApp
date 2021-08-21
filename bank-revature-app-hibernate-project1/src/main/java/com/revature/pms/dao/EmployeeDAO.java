package com.revature.pms.dao;


import com.revature.pms.model.Employee;

public interface EmployeeDAO {
	public int addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean isEmployeeExists(int employeeId);
	public Employee getEmployeeById(int employeeId);
	public boolean permission();

}
