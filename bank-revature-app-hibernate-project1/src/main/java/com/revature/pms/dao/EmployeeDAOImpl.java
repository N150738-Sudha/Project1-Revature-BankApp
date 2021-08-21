package com.revature.pms.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.pms.dao.EmployeeDAO;
import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
private static Logger logger = Logger.getLogger("CustomerDAOImpl");
	
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	public int addEmployee(Employee employee) {
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		return employee.getEmployeeId();
	}

	public boolean updateEmployee(Employee employee) {
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		return true;
	}

	public boolean isEmployeeExists(int employeeId) {
		Employee employee =  (Employee) session.get(Employee.class, employeeId);
		if(employee ==null) {
			System.out.println(employeeId+" doesn't exists");
			return false;
		}
		else {
			System.out.println(employee.getEmployeeName()+" exists");
			return true;
			
		}
	}

	public boolean permission() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Employee employee =  (Employee) session.load(Employee.class, employeeId);
		return employee;
	}

}
