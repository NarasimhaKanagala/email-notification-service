package com.example.test;

import com.example.test.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
public class EmailNotificationServiceApplication {
	@Autowired
	private EmailSenderService emailSenderService;





	public static void main(String[] args) {
		SpringApplication.run(EmailNotificationServiceApplication.class, args);


	}


	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/schema1");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("simha");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return driverManagerDataSource;
	}
}



