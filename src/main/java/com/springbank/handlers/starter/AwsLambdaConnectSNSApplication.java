package com.springbank.handlers.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.springbank" })
public class AwsLambdaConnectSNSApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsLambdaConnectSNSApplication.class, args);
	}

}
