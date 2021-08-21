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
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class AuthenticateUser
 */
public class AuthenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String password = request.getParameter("password");

		CustomerService customerService = new CustomerServiceImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(customerService.isCustomerExists(customerId)) {
			Customer customer = customerService.getCustomerById(customerId);
			if(customer.getPassword().equals(password)) {
				
				out.println("<h3>"+customer.getCustomerName()+", You are successfully logged into your account at : " + new java.util.Date()+"</h3>");
				HttpSession session = request.getSession();
				session.setAttribute("customerName", customer.getCustomerName());
				session.setAttribute("customerId", customerId);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("customerUserStories.html");
				dispatcher.include(request, response);
				
			}
			else {
				out.println("<h4>The password that you have entered is wrong</h4>");
				out.println("<h4>Please try again   <h4>");
				out.println("<h3><a href=customerLoginForm.html>click here</a></he>");
			}
		}
		else {
			out.println("<p>Customer Id "+customerId+" is doesn't exist");
			out.println("<p>If you are a new user, then register below to create new account</h2>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customerForm.html");
			dispatcher.include(request, response);
		}
		out.println("</body></html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String password = request.getParameter("password");

		CustomerService customerService = new CustomerServiceImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(customerService.isCustomerExists(customerId)) {
			Customer customer = customerService.getCustomerById(customerId);
			if(customer.getPassword().equals(password)) {
				
				out.println(customer.getCustomerName()+", You are successfully logged into your account at : " + new java.util.Date());
				
				HttpSession session = request.getSession();
				session.setAttribute("customerName", customer.getCustomerName());
				session.setAttribute("customerId", customerId);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("customerUserStories.html");
				dispatcher.include(request, response);
				
			}
			else {
				out.println("<h2>The password that you have entered is wrong</h2>");
				out.println("<h2>Please try again   <h2>");
				out.println("<a href=customerLoginForm.html>click here</a>");
			}
		}
		else {
			out.println("<h2>Customer Id "+customerId+" is doesn't exist");
			out.println("<h2>If you are a new user, then register below to create new account</h2>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customerLoginForm.html");
			dispatcher.include(request, response);
		}
		out.println("</body></html>");
	}

}
