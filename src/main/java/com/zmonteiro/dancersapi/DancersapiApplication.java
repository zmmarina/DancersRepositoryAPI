package com.zmonteiro.dancersapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class DancersapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DancersapiApplication.class, args);
		System.out.println("art with webflux");
	}

}
