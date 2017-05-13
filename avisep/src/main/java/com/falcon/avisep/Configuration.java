package com.falcon.avisep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Configuration {
	public static void main(String[] args) {
		SpringApplication.run(Configuration.class, args);
	}
//	@Bean
//	public DataSource dataSource(){
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("org.postgresql.Driver");
//	    dataSource.setUrl("jdbc:postgresql://localhost:5432/avisepdb");
//	    dataSource.setUsername("postgres");
//	    dataSource.setPassword("falconteama2");
//	    return dataSource;
//	}
	
}
