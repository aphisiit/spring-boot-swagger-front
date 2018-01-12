package com.swagger.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import com.swagger.front.spring.ApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = "com.swagger.front")
@EnableAutoConfiguration
@Import({ApplicationConfiguration.class})
public class SwaggerFrontApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerFrontApplication.class, args);
	}
}
