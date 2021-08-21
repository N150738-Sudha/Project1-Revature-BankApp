package com.revature.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class EmployeeActionController
 */
public class EmployeeActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeActionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		CustomerService customerService = new CustomerServiceImpl();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		switch (action) {
		case "getCustomerById":
			int customerId = Integer.parseInt(request.getParameter("customerId"));
			if (customerService.isCustomerExists(customerId)) {
				Customer customer = customerService.getCustomerById(customerId);
				List<Customer> customers = new ArrayList<Customer>();
				customers.add(customer);
				session.setAttribute("allCustomers", customers);
				RequestDispatcher dispatcher = request.getRequestDispatcher("displayCustomerDetails.jsp");
				dispatcher.include(request, response);
			} else {
				out.println("<h3 color='red'>Customer with customerId " + customerId + " doesn't exists");
				RequestDispatcher dispatcher = request.getRequestDispatcher("getCustomerById.html");
				dispatcher.include(request, response);
			}

			
			break;
		case "getCustomerByName":
			String customerName = request.getParameter("customerName");
			if (customerService.isCustomerExistsByName(customerName)) {
				List<Customer> allCustomers = customerService.getCustomerByName(customerName);
				session.setAttribute("allCustomers", allCustomers);
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("displayCustomerDetails.jsp");
				dispatcher1.include(request, response);
			} else {
				out.println("<h3 color='red'>Customer with customerName " + customerName + " doesn't exists");
				RequestDispatcher dispatcher = request.getRequestDispatcher("getCustomerByName.html");
				dispatcher.include(request, response);
			}

			
			break;

		}
		out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
