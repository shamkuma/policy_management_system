package com.policy.management.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.policy.management.model.PolicyData;
import com.policy.management.model.UserDetail;
import com.policy.management.model.UserPolicyData;

@Repository
public class PolicyDAOImpl implements PolicyDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean validateUserLogin(String userId, String password) {
		String query=VALIDATE_LOGIN_QUERY;
		query = query.replace("_userId_",userId);
		query = query.replace("_pass_",password);
		Integer count= jdbcTemplate.queryForObject(query, Integer.class);
		if(count==0) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public boolean saveUserDetail(UserDetail userDetail) throws SQLException, DataAccessException{
		return jdbcTemplate.execute(SAVE_USER_DETAIL,new PreparedStatementCallback<Boolean>(){  
		    @Override  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		    	ps.setString(1,userDetail.getUserId());     
		        ps.setString(2,userDetail.getEmailAdd());  
		        ps.setString(3,userDetail.getFirstName());  
		        ps.setString(4,userDetail.getLastName());
		        ps.setDate(5,new java.sql.Date(userDetail.getDob().getTime()));  
		        ps.setString(6,userDetail.getAddress());
		        ps.setString(7,userDetail.getContactNo());
		        ps.setString(8,userDetail.getPassword());
		        ps.setString(9,userDetail.getConfPassword());
		              
		        ps.execute();  
		        return true;
		              
		    }  
		    });  
		}

	@Override
	public List<PolicyData> getAllPolicy() throws SQLException, DataAccessException {
		List<Map<String,Object>> rows=jdbcTemplate.queryForList(GET_ALL_POLICY_DETAIL);
		
		List<PolicyData> policyDataList= new ArrayList<PolicyData>();
		rows.forEach(row->{
			PolicyData policyData=new PolicyData();
			BigDecimal policyID=(BigDecimal)row.get("POLICY_ID");
			policyData.setPolicyNo(policyID.intValue());
			policyData.setPolicyName((String)row.get("POLICY_NAME"));
			policyData.setPolicyDetail((String)row.get("POLICY_DETAILS"));
			policyDataList.add(policyData);
			
		});
		return policyDataList;
	}

	@Override
	public List<UserPolicyData> getUserPolicy(String userId) throws SQLException, DataAccessException {
		
		//POLICY_ID,AMOUNT_PAID,POLICY_EXP_DATE,VALID
		String query=GET_USER_POLICY_DETAIL;
		query= query.replace("_userId_", userId);
		List<Map<String,Object>> rows=jdbcTemplate.queryForList(query);
		
		List<UserPolicyData> userPolicyDataList= new ArrayList<UserPolicyData>();
		rows.forEach(row->{
			UserPolicyData userPolicyData=new UserPolicyData();
			BigDecimal policyID=(BigDecimal)row.get("POLICYID");
			userPolicyData.setPolicyNo(policyID.intValue());
			userPolicyData.setPolicyName((String)row.get("POLICYNAME"));
			BigDecimal amount=(BigDecimal)row.get("AMOUNT");
			userPolicyData.setAmountPaid(amount.doubleValue());
			Date endDate=(Date)row.get("ENDDATE");
			userPolicyData.setPolicyEndDate((Date)row.get("ENDDATE"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			userPolicyData.setStrPolicyEndDate(formatter.format(endDate));
			
			String VALID=(String)row.get("VALID");
			if(!StringUtils.isEmpty(VALID)) {
				if(VALID.equals("Y")) {
					userPolicyData.setValid(true);
				}else {
					userPolicyData.setValid(false);
				}
			}
			
			userPolicyDataList.add(userPolicyData);
			
		});
		return userPolicyDataList;
	}

	@Override
	public int updatePolicy(PolicyData policyData) throws SQLException, DataAccessException {
		
		
		int id=jdbcTemplate.update(UPDATE_POLICY, new PreparedStatementSetter() {
			   
	         public void setValues(PreparedStatement preparedStatement) throws SQLException {
	            preparedStatement.setString(1, policyData.getPolicyName());
	            preparedStatement.setString(2, policyData.getPolicyDetail());
	            preparedStatement.setInt(3, policyData.getPolicyNo());
	         }
		});
		return id;
	}  
	
	}

