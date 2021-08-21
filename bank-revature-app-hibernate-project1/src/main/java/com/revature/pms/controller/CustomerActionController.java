package com.revature.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerActionController
 */
public class CustomerActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerActionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int amount = Integer.parseInt(request.getParameter("amount"));
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);

		int customerId = (int) session.getAttribute("customerId");
		System.out.println(customerId);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		CustomerService customerService = new CustomerServiceImpl();
		int availableBalance = customerService.viewBalance(customerId);
		switch (action) {
		case "withdraw":
			if (availableBalance < amount) {
				out.println("<h2>Your account doesn't consists sufficient amount to withdraw");
			} else {
				int balance = customerService.withdraw(amount, customerId);
				out.println("<h1>INR " + amount
						+ " is withdrawn into your account and now your available balance is INR " + balance);
			}
			out.println("<a href=customerUserStories.html>Home</a>");
			break;
		case "deposit":
			int newBalance = customerService.deposit(amount, customerId);
			out.println("<h1>INR " + amount + " is deposited into your account and now your available balance is INR "
					+ newBalance);
			out.println("<a href=customerUserStories.html>Home</a>");
			break;
		case "transfer":
			int receiverCustomerId = Integer.parseInt(request.getParameter("customerId"));
			if (availableBalance < amount) {
				out.println("<h2>Your account doesn't consists sufficient amount to transfer");
			} else {
				int remainingBalance = customerService.transferAmount(customerId, receiverCustomerId, amount);

				out.println("<h1>INR " + amount + " is transferred from your account to CustomerId "
						+ receiverCustomerId + " account and your current balance is " + remainingBalance);
			}
			out.println("<a href=customerUserStories.html>Home</a>");
			break;
		
		}
		out.println("</body></html>");

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
