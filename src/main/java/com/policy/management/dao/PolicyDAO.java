package com.policy.management.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.policy.management.model.PolicyData;
import com.policy.management.model.UserDetail;
import com.policy.management.model.UserPolicyData;

public interface PolicyDAO {

	String VALIDATE_LOGIN_QUERY="select count(*) from POLICY_USER_DETAIL where USERID='_userId_' and PASSWORD1='_pass_'";
	String SAVE_USER_DETAIL="insert into POLICY_USER_DETAIL (USERID,email_add, firstName ,lastName , dob ,  address , contactNo , password1 , cnfpassword ) values(?,?,?,?,?,?,?,?,?)";
	String GET_ALL_POLICY_DETAIL="select POLICY_ID,POLICY_NAME,POLICY_DETAILS from POLICY";
	String GET_USER_POLICY_DETAIL="select upd.POLICY_ID as POLICYID,p.POLICY_NAME as POLICYNAME,upd.AMOUNT_PAID as AMOUNT ,upd.POLICY_EXP_DATE as ENDDATE,upd.VALID as "
			+ "VALID from USER_POLICY_DETAIL upd,POLICY p where USER_ID='_userId_' and upd.POLICY_ID=p.POLICY_ID ";
	
	String UPDATE_POLICY="update POLICY SET POLICY_NAME= ? , POLICY_DETAILS= ? where POLICY_ID= ?";
	
	
	public boolean validateUserLogin(String userId, String password) ;
	public boolean saveUserDetail(UserDetail userDetail) throws SQLException, DataAccessException;
	public List<PolicyData> getAllPolicy() throws SQLException, DataAccessException;
	public List<UserPolicyData> getUserPolicy(String userId) throws SQLException, DataAccessException;
	public int updatePolicy(PolicyData policyData) throws SQLException, DataAccessException;
}
