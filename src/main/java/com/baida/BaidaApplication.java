package com.baida;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaidaApplication {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(BaidaApplication.class);

		SpringApplication.run(BaidaApplication.class, args);
		logger.info("......启动完毕......");
	}
}
