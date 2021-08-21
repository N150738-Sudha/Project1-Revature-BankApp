package com.revature.pms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_employees")
public class Employee implements Serializable {
	// fields of customer class
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int employeeId;
	
	@Column
	private String employeeName;
	
	@Column
	private String password;
	
	@Column
	private int salary;
	
	@Column
	private String mobileNumber;
	
	@Column
	private String email;
	
	@Column
	private Date registrationDate;
	
	// Default constructor
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	

	public Employee(int employeeId, String employeeName, String password, int salary, String mobileNumber,
			String email, Date registrationDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.salary = salary;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.registrationDate = registrationDate;
	}


	public int getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}




	public String getEmployeeName() {
		return employeeName;
	}




	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getSalary() {
		return salary;
	}




	public void setSalary(int salary) {
		this.salary = salary;
	}




	public String getMobileNumber() {
		return mobileNumber;
	}




	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Date getRegistrationDate() {
		return registrationDate;
	}




	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}




	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", salary=" + salary + ", mobileNumber=" + mobileNumber + ", email=" + email + ", registrationDate="
				+ registrationDate + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(email, employeeId, employeeName, mobileNumber, password, registrationDate, salary);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && employeeId == other.employeeId
				&& Objects.equals(employeeName, other.employeeName) && mobileNumber == other.mobileNumber
				&& Objects.equals(password, other.password) && Objects.equals(registrationDate, other.registrationDate)
				&& salary == other.salary;
	}




	
	
}

