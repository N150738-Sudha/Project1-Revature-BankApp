package com.revature.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AuthenticateUser
 */
public class AuthenticateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String password = request.getParameter("password");

		EmployeeService employeeService = new EmployeeServiceImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(employeeService.isEmployeeExists(employeeId)) {
			Employee employee = employeeService.getEmployeeById(employeeId);
			if(employee.getPassword().equals(password)) {
				
				out.println(employee.getEmployeeName()+", You are successfully logged into your account at : " + new java.util.Date());
				HttpSession session = request.getSession();
				session.setAttribute("employeeName", employee.getEmployeeName());
				session.setAttribute("employeeId", employeeId);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("employeeUserStories.html");
				dispatcher.include(request, response);
				
			}
			else {
				out.println("<h2>The password that you have entered is wrong</h2>");
				out.println("<h2>Please try again   <h2>");
				out.println("<a href=employeeLoginForm.html>click here</a>");
			}
		}
		else {
			out.println("<h4>Employee Id "+employeeId+" is doesn't exist");
			out.println("<h4>If you are a new user, then register below to create new account</h4>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeLoginForm.html");
			dispatcher.include(request, response);
		}
		out.println("</body></html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
