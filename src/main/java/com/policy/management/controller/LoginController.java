package com.policy.management.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.policy.management.model.PolicyData;
import com.policy.management.model.User;
import com.policy.management.model.UserDetail;
import com.policy.management.service.PolicyService;

@Controller
public class LoginController {
	
	@Autowired
	PolicyService policyService;

	
	@GetMapping("/")
	public String about(Model model) {
		model.addAttribute("user",new User());
		return "about";
	}
	@GetMapping("/about")
	public String about1(Model model) {
		model.addAttribute("user",new User());
		return "about";
	}

	@GetMapping("/login")
	public String welcome(Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	
	@GetMapping("/contactus")
	public String contactus(Model model) {
			return "contactus";
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		
		return "about";
	}

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("userDetail",new UserDetail());
		
		return "userRegistration";
	}
	
	@RequestMapping("/submitlogin")
	public String submitlogin(@ModelAttribute("user") User user, Model model) throws DataAccessException, SQLException {
		
		if(user.getUserId().equals("Admin")) {
			if(user.getPassword().equals("Admin")) {
				user.setPolicyDataList(policyService.getAllPolicy());
				model.addAttribute("user", user);
				return "showAdminPolicy";
			}else {
				model.addAttribute("adminLoginFailed",true);
				model.addAttribute("userId",user);
				return "login";
			}
		}
		if(!user.getUserId().equals("Admin")) {
			Boolean valid=policyService.validateUserLogin(user.getUserId(), user.getPassword());
			if(valid) {
				user.setPolicyDataList(policyService.getAllPolicy());
				user.setUserPolicyDataList(policyService.getUserPolicy(user.getUserId()));
				model.addAttribute("user", user);
				return "showUserPolicy";
			}else {
				model.addAttribute("userLoginFailed",true);
				model.addAttribute("userId",user);
				return "login";
			}
		}
		return "welcome";
	}
	@PostMapping("/saveUser")
	public String registerUser(@ModelAttribute("userDetail") UserDetail userDetail, Model model) {
		
		Boolean save=false;
		String USER_ID="";
		try {
			 USER_ID=getUserId(userDetail.getFirstName(), userDetail.getDob());
			userDetail.setUserId(USER_ID);
			save = policyService.saveUserDetail(userDetail);
		} catch (DataAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("showMessage","notSaved");
			model.addAttribute("userDetail",userDetail);
			return "userRegistration";
			
		}
		model.addAttribute("userDetail",userDetail);
		if(save) {
			model.addAttribute("showMessage","saved");
			model.addAttribute("userID",USER_ID);
			
		}
		else {
				model.addAttribute("showMessage","notSaved");
			}
		
		return "userRegistration";
	}
	/*
	 * var ajax_data =
	[
		{slNo:"Code", policyName:"With Mark", policyDetails:"mark@codewithmark.com"}, 
		{fname:"Mary", lname:"Moe", email:"mary@gmail.com"},
		{fname:"John", lname:"Doe", email:"john@yahoo.com"},
		{fname:"Julie", lname:"Dooley", email:"julie@gmail.com"},
	]

	 */
	@GetMapping("/getAllPolicyData")
	public void getAllPolicyData(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws DataAccessException, SQLException, IOException {
		List<PolicyData> policyDataList=policyService.getAllPolicy();
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(policyDataList);
	
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}
	

	@PostMapping("/updatePolicy")
	public void updatePolicy(@RequestBody PolicyData policyData) throws DataAccessException, SQLException {
		
		policyService.updatePolicy(policyData);
	}
	private String getUserId(String fname, Date dob) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		String day_str="";
		String month_str="";
		
		Instant instant = dob.toInstant();
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		
		int day=localDate.getDayOfMonth();
		int month=localDate.getMonthValue();
		if(day<10) {
			day_str="0"+day;
		}else {
			day_str=""+day;
		}
		if(month<10) {
			month_str="0"+month;
		}else {
			month_str=""+month;
		}
		return fname+day_str+month_str;

	}
}