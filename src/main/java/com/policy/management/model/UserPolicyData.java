package com.policy.management.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserPolicyData {
	private Integer policyNo;
	private String policyName;
	private double amountPaid;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date policyEndDate;
	
	private String strPolicyEndDate;
	private Boolean valid;
	/**
	 * @return the policyNo
	 */
	public Integer getPolicyNo() {
		return policyNo;
	}
	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(Integer policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * @return the policyName
	 */
	public String getPolicyName() {
		return policyName;
	}
	/**
	 * @param policyName the policyName to set
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	/**
	 * @return the amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}
	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	/**
	 * @return the policyEndDate
	 */
	public Date getPolicyEndDate() {
		return policyEndDate;
	}
	/**
	 * @param policyEndDate the policyEndDate to set
	 */
	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}
	/**
	 * @return the valid
	 */
	public Boolean getValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	/**
	 * @return the strPolicyEndDate
	 */
	public String getStrPolicyEndDate() {
		return strPolicyEndDate;
	}
	/**
	 * @param strPolicyEndDate the strPolicyEndDate to set
	 */
	public void setStrPolicyEndDate(String strPolicyEndDate) {
		this.strPolicyEndDate = strPolicyEndDate;
	}
	

}
