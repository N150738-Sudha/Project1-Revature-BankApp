package com.revature.pms.dao;

import java.util.List;

import com.revature.pms.model.Customer;

public interface CustomerDAO {
	public int addCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomerByName(String customerName);
	public List<Customer> getCustomers();
	public boolean isCustomerExists(int customerId);
	public boolean isCustomerExistsByName(String customerName);
	
	//* As a customer, I can view the balance of a specific account. * 
	public int viewBalance(int customerId);
	
	//As a customer, I can make a withdrawal or deposit to a specific/my account. 
	public int deposit(int amount,int customerId);
	public int withdraw(int amount, int customerId);
	public int transferAmount(int senderId,int receiverId,int amount);
}
