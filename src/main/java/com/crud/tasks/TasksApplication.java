package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//dla zewnętrznego Tomcata
//public class TasksApplication extends SpringBootServletInitializer {
//dla lokalnego MySQL i Heroku
public class TasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}
//dla zewnętrznego Tomcata
//	@Override
//	protected SpringApplicationBuilder configure (SpringApplicationBuilder application) {
//		return application.sources(TasksApplication.class);
//	}
}