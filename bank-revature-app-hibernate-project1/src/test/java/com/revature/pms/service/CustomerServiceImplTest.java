package com.revature.pms.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pms.model.Customer;

public class CustomerServiceImplTest {
	private CustomerService customerService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customerService = new CustomerServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		customerService = null;
	}
	int customerId = 0;
	@Test
	
	public void testAddCustomer() {
		List<Customer> originalCustomerCount1 = customerService.getCustomers();
		customerId = customerService.addCustomer(new Customer(0,"123","name",200,"123","1000",new Date()));
		List<Customer> originalCustomerCount2 = customerService.getCustomers();

		
		assertEquals(originalCustomerCount2.size(),originalCustomerCount1.size()+1);
		
	}

	@Test
	public void testDeleteCustomer() {
		boolean out = customerService.deleteCustomer(customerId);
		assertEquals(out,true);
	}

	

	@Test
	public void testGetCustomerById() {
		customerId = 1;
		Customer customer = customerService.getCustomerById(customerId);
		assertEquals(customer.getCustomerName(),"Dhana");
	}

	@Test
	public void testGetCustomers() {
		List<Customer> originalCustomerCount1 = customerService.getCustomers();
		customerId = customerService.addCustomer(new Customer(0,"123","name",200,"123","1000",new Date()));
		List<Customer> originalCustomerCount2 = customerService.getCustomers();

		
		assertEquals(originalCustomerCount2.size(),originalCustomerCount1.size()+1);
	}

	@Test
	public void testIsCustomerExists() {
		customerId = 1;
		boolean out = customerService.isCustomerExists(customerId);
		assertEquals(out,true);
	}

	@Test
	public void testViewBalance() {
		customerId = 13;
		int balance = customerService.viewBalance(customerId);
		assertEquals(balance,4800);
		
	}

	@Test
	public void testDeposit() {
		int customerId =1;
		int balanceBeforeDeposit = customerService.viewBalance(customerId);
		int balanceAfterDeposit = customerService.deposit(100, customerId);
		assertEquals(balanceBeforeDeposit,balanceAfterDeposit-100);
	}

	@Test
	public void testWithdraw() {
		int customerId =1;
		int balanceBeforeWithdraw = customerService.viewBalance(customerId);
		int balanceAfterWithdraw = customerService.withdraw(100, customerId);
		assertEquals(balanceBeforeWithdraw,balanceAfterWithdraw+100);
	}

	@Test
	public void testTransferAmount() {
		int customerId =1;
		int balanceBeforeTransfer = customerService.viewBalance(customerId);
		int balanceAfterTransfer = customerService.transferAmount(customerId,2,100);
		assertEquals(balanceBeforeTransfer,balanceAfterTransfer+100);
	}

}
