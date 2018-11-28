package com.policy.management.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDetail {
	private String userId;
	
	private String firstName;
	private String lastName;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dob;
	private String address;
	private String contactNo;
	private String emailAdd;
	private String password;
	private String confPassword;
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the emailAdd
	 */
	public String getEmailAdd() {
		return emailAdd;
	}
	/**
	 * @param emailAdd the emailAdd to set
	 */
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confPassword
	 */
	public String getConfPassword() {
		return confPassword;
	}
	/**
	 * @param confPassword the confPassword to set
	 */
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
