package com.policy.management.model;

import java.util.List;

public class User {
	
	private String userId;
	private String password;
	private List<PolicyData> policyDataList;
	private List<UserPolicyData> userPolicyDataList;
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
	 * @return the userPolicyDataList
	 */
	public List<UserPolicyData> getUserPolicyDataList() {
		return userPolicyDataList;
	}
	/**
	 * @param userPolicyDataList the userPolicyDataList to set
	 */
	public void setUserPolicyDataList(List<UserPolicyData> userPolicyDataList) {
		this.userPolicyDataList = userPolicyDataList;
	}
	/**
	 * @return the policyDataList
	 */
	public List<PolicyData> getPolicyDataList() {
		return policyDataList;
	}
	/**
	 * @param policyDataList the policyDataList to set
	 */
	public void setPolicyDataList(List<PolicyData> policyDataList) {
		this.policyDataList = policyDataList;
	}

}
