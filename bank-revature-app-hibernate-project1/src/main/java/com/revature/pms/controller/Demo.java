package com.revature.pms.controller;

import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

public class Demo {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerServiceImpl();
		customerService.deleteCustomer(5);

	}

}
