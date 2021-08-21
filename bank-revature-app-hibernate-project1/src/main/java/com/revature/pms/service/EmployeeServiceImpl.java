package com.revature.pms.service;

import com.revature.pms.dao.EmployeeDAO;
import com.revature.pms.dao.EmployeeDAOImpl;
import com.revature.pms.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	public int addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	public boolean isEmployeeExists(int employeeId) {
		return employeeDAO.isEmployeeExists(employeeId);
	}

	public boolean permission() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeById(employeeId);
	}

}
