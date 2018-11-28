package com.policy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySources;


//@ComponentScan(basePackages= {"com.policy.management.*"})
@SpringBootApplication

public class PolicyManagementSystem extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PolicyManagementSystem.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PolicyManagementSystem.class, args);
	}

}