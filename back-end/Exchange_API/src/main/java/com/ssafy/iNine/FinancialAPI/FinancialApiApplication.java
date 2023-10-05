package com.ssafy.iNine.FinancialAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FinancialApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialApiApplication.class, args);
	}

}
