package com.example.customers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CustomersApplication implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String appName;

	@Value("${version}")
	private String appVersion;

	@Value("${enviroment}")
	private String env;

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("------------------------------------------------------------------------------");
		log.info("-           "+ appName + " V: " + appVersion + " Env: " + env + "                                      -");
		log.info("------------------------------------------------------------------------------");
	}
}
