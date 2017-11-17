package com.bridgelabz.fundooPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bridgelabz.fundooPay")
public class FundooPaySwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooPaySwaggerApplication.class, args);
	}
}
