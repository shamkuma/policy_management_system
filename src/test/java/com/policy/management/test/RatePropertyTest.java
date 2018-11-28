

package com.policy.management.test;

 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.policy.management.model.RatePropertyLoader;

 


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
    classes={RatePropertyLoader.class})

              

public class RatePropertyTest {

       

      
 

       @Autowired

       private RatePropertyLoader ratePropertyLoader;

 

      

 

       



 

    @Test

    public void test1() throws Exception {

 

       System.out.println("getting first Property"+ratePropertyLoader.getProperty("rate.test1"));

       

    }

   
   

   

 

       

       

 

}
