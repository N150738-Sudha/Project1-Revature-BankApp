package com.revature.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName = request.getParameter("employeeName");
		String password = request.getParameter("password");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String mobile = request.getParameter("mobile");
		String emailId = request.getParameter("emailId");
		
		Employee employee = new Employee(0 ,employeeName , password, salary, mobile, emailId, new Date());
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		int employeeId = employeeService.addEmployee(employee);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+employeeName + ", congrats you have successfully opened an account in our bank ");
		out.println("<h2>You can login into your account now with your employeeId "+employeeId);
		out.println("<h2><a href=employeeLoginForm.html>Login</a></h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
