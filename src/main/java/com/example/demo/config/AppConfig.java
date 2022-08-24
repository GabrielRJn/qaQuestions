package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.*;


@Configuration
public class AppConfig {

	
	@Bean
	public String greeting() {
		return "Hello";
	}
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}



