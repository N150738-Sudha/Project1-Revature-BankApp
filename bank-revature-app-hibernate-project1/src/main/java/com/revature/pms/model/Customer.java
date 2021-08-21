package com.revature.pms.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@Column
	private String password;

	@Column
	private String customerName;

	@Column
	private int balance;
	
	@Column
	private String mobileNumber;

	@Column
	private String emailId;

	@Column
	private Date registrationDate;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Customer(int customerId, String password, String customerName, int balance, String mobileNumber,
			String emailId, Date registrationDate) {
		this.customerId = customerId;
		this.password = password;
		this.customerName = customerName;
		this.balance = balance;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.registrationDate = registrationDate;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, customerId, customerName, emailId, mobileNumber, password, registrationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return balance == other.balance && customerId == other.customerId
				&& Objects.equals(customerName, other.customerName) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(password, other.password)
				&& Objects.equals(registrationDate, other.registrationDate);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", password=" + password + ", customerName=" + customerName
				+ ", balance=" + balance + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", registrationDate=" + registrationDate + "]";
	}
	
	
}
