package com.codemer.giftcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringBootSwaggerDocumentaionApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerDocumentaionApplication.class, args);
	}

	
	
}
