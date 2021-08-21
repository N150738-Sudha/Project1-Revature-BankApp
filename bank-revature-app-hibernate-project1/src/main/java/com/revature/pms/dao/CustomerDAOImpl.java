package com.revature.pms.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.model.Customer;
import com.revature.pms.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {

	private static Logger logger = Logger.getLogger("CustomerDAOImpl");
	
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	
	public int addCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		//new state
		//transient state
		session.save(customer);
		//persistent state
		transaction.commit();
		//detached
		return customer.getCustomerId();
	}

	public boolean deleteCustomer(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		session.delete(customer);
		transaction.commit();
		return true;
	}

	public boolean updateCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.update(customer);
		transaction.commit();
		return true;
	}

	public Customer getCustomerById(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer =  (Customer) session.load(Customer.class, customerId);
		transaction.commit();
		return customer;
	}
	
	@Override
	public List<Customer> getCustomerByName(String customerName) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from com.revature.pms.model.Customer where customerName=:name");
		query.setParameter("name", customerName);
		List<Customer> customers = query.list();
		transaction.commit();
		System.out.println(customers);
		return customers;
	}

	public List<Customer> getCustomers() {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from com.revature.pms.model.Customer");
		List<Customer> customers = query.list();
		transaction.commit();
		System.out.println(customers);
		return customers;
	}

	public boolean isCustomerExists(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer =  (Customer) session.get(Customer.class, customerId);
		transaction.commit();
		if(customer ==null)
			return false;
		else
			return true;
	}

	//HQL - Hibernate Query Language
	//instead of working on tables and columns in works on POJOS and properties
	public int viewBalance(int customerId) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select balance from com.revature.pms.model.Customer where customerId = "+customerId);
		int balance = (Integer) query.list().get(0);
		transaction.commit();
		logger.info("The balance for :"+customerId + " is "+balance);
		return balance;
	}

	public int deposit(int amount, int customerId) {
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("update com.revature.pms.model.Customer set balance=balance+"+amount+" where customerId="+customerId);
		query.executeUpdate();
		transaction.commit();
		int balance = viewBalance(customerId);
		return balance;
	}

	public int withdraw(int amount,int customerId) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update com.revature.pms.model.Customer set balance=balance-"+amount+" where customerId="+customerId);
		query.executeUpdate();
		transaction.commit();
		int balance = viewBalance(customerId);
		return balance;
	}

	public int transferAmount(int senderId, int receiverId, int amount) {
		Transaction transaction = session.beginTransaction();
		Query query1 = session.createQuery("update com.revature.pms.model.Customer set balance=balance-"+amount+" where customerId="+senderId);
		query1.executeUpdate();
		Query query2 = session.createQuery("update com.revature.pms.model.Customer set balance=balance+"+amount+" where customerId="+receiverId);
		query2.executeUpdate();
		transaction.commit();
		int balance = viewBalance(senderId);
		System.out.println("Your current balance is "+balance);
		return balance;
	}

	@Override
	public boolean isCustomerExistsByName(String customerName) {
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from com.revature.pms.model.Customer where customerName=:name");
		query.setParameter("name", customerName);
		List<Customer> customers = query.list();
		transaction.commit();
		if(customers ==null)
			return false;
		else
			return true;
	}

	

}
