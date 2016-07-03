package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
@EnableEurekaClient
public class Application implements CommandLineRunner{

	@Autowired
	private MongoTemplate mongoTemplate;	
	
	private Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//create the user collection if it does not exists
	@Override
	public void run(String... arg0) throws Exception {		
		if (!mongoTemplate.getCollectionNames().contains("users")) {
		    mongoTemplate.createCollection("users");
		    logger.info("Created MongoDB Collection: users.");
		}else{
			logger.info("users Collection in MongoDB already exists");
		}
	}
}
