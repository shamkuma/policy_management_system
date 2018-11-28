package com.policy.management.test;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import  org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.policy.PolicyManagementSystem;
import com.policy.management.controller.LoginController;
import com.policy.management.dao.PolicyDAO;
import com.policy.management.model.User;
import com.policy.management.service.PolicyService;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class )
@ContextConfiguration(classes = PolicyManagementSystem.class)

public class PolicyManagementApplicationControllerTest {

       @Autowired
       private MockMvc mockMvc;
       
       @MockBean
       private PolicyService policyService;
       
       @MockBean
       private PolicyDAO policyDao;
 

    @Test

    public void test1() throws Exception {

 

        mockMvc.perform(get("/"))

            .andExpect(status().isOk())

            .andExpect(view().name("about"))

            .andExpect(forwardedUrl("/WEB-INF/jsp/about.jsp"));

       

    }

    

    @Test

    public void test2() throws Exception {

 

        mockMvc.perform(get("/register"))

            .andExpect(status().isOk())

            .andExpect(view().name("userRegistration"))

            .andExpect(forwardedUrl("/WEB-INF/jsp/userRegistration.jsp"));

       

    }

    

    @Test

    public void test3() throws Exception {

 

        mockMvc.perform(get("/login"))

            .andExpect(status().isOk())

            .andExpect(view().name("login"))

            .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));

       

    }

    

    @Test

    public void test4() throws Exception {

        String userId = "Admin";

        String password = "Admin";



        mockMvc.perform(post("/submitlogin")

                       .contentType(MediaType.APPLICATION_FORM_URLENCODED)

                .param("userId", userId)

                .param("password", password)

                .sessionAttr("user", new User())

        )

                .andExpect(status().isOk())

                .andExpect(view().name("showAdminPolicy"))

                .andExpect(forwardedUrl("/WEB-INF/jsp/showAdminPolicy.jsp"));

               

       

    }

    

    @Test

    public void test4_1() throws Exception {

        String userId = "Admin";

        String password = "Not Admin";



        mockMvc.perform(post("/submitlogin")

                       .contentType(MediaType.APPLICATION_FORM_URLENCODED)

                .param("userId", userId)

                .param("password", password)

                .sessionAttr("user", new User())

        )

                .andExpect(status().isOk())

                .andExpect(view().name("login"))

                .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp")).andExpect(model().attribute("adminLoginFailed", is(true)));

               

       

    }

   

    @Test

    public void test5() throws Exception {

        String userId = "shambhu2006";

        String password = "11";

         when(policyService.validateUserLogin(userId, password)).thenReturn(true);

 

        mockMvc.perform(post("/submitlogin")

                       .contentType(MediaType.APPLICATION_FORM_URLENCODED)

                .param("userId", userId)

                .param("password", password)

                .sessionAttr("user", new User())

        )

                .andExpect(status().isOk())

                .andExpect(view().name("showUserPolicy"))

                .andExpect(forwardedUrl("/WEB-INF/jsp/showUserPolicy.jsp"));

               

       

    }

    

    @Test

    public void test5_1() throws Exception {

        String userId = "shambhu2006";

        String password = "Wrong Password";

         when(policyService.validateUserLogin(userId, password)).thenReturn(false);

 

        mockMvc.perform(post("/submitlogin")

                       .contentType(MediaType.APPLICATION_FORM_URLENCODED)

                .param("userId", userId)

                .param("password", password)

                .sessionAttr("user", new User())

        )

        .andExpect(status().isOk())

        .andExpect(view().name("login"))

        .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp")).andExpect(model().attribute("userLoginFailed", is(true)));

               

       

    }

   

   

 

       

       

 

}
