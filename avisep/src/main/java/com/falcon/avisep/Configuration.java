package com.falcon.avisep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
//	    dataSource.setPassword("root92");
//	    return dataSource;
//	}
}
