package com.policy.management.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.policy.management.model.PolicyData;
import com.policy.management.model.UserDetail;
import com.policy.management.model.UserPolicyData;

public interface PolicyService {
	
	public boolean validateUserLogin(String userId, String password) ;
	public boolean saveUserDetail(UserDetail userDetail) throws SQLException, DataAccessException;
	public List<PolicyData> getAllPolicy() throws SQLException, DataAccessException;
	public List<UserPolicyData> getUserPolicy(String userId) throws SQLException, DataAccessException;
	public int updatePolicy(PolicyData policyData) throws SQLException, DataAccessException;

}
