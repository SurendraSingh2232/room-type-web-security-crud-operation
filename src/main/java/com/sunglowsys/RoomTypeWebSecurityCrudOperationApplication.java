package com.sunglowsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "com.sunglowsys.repository")
@ComponentScan(basePackages = "com.sunglowsys")
@EntityScan(basePackages = "com.sunglowsys.domain")
public class RoomTypeWebSecurityCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomTypeWebSecurityCrudOperationApplication.class, args);
	}

}
