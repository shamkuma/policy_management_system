package com.policy.management.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.policy.management.dao.PolicyDAO;
import com.policy.management.model.PolicyData;
import com.policy.management.model.UserDetail;
import com.policy.management.model.UserPolicyData;

@Service
public class PolicyServiceImpl implements PolicyService{

	@Autowired 
	PolicyDAO policyDao;
	
	public boolean saveUserDetail(UserDetail userDetail) throws SQLException, DataAccessException{
		
		
		return policyDao.saveUserDetail(userDetail);
	}

	@Override
	public boolean validateUserLogin(String userId, String password) {
		return policyDao.validateUserLogin(userId, password);
	}

	@Override
	public List<PolicyData> getAllPolicy() throws SQLException, DataAccessException {
		
		return policyDao.getAllPolicy();
	}

	@Override
	public List<UserPolicyData> getUserPolicy(String userId) throws SQLException, DataAccessException {
		
		return policyDao.getUserPolicy(userId);
	}
	@Override
	public int updatePolicy(PolicyData policyData) throws SQLException, DataAccessException{
		return policyDao.updatePolicy(policyData);
	}
}
