package com.policy.management.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/rate.properties")
public class RatePropertyLoader {

	@Autowired
	Environment env;
	static Environment envstatic;
	
	@PostConstruct
	public void init() {
		envstatic=env;
	}
	
	public String getProperty(String prop) {
		
		return env.getProperty(prop);
	}
	
	
	
	
	
}
