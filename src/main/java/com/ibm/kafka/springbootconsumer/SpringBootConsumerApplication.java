package com.ibm.kafka.springbootconsumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SpringBootConsumerApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootConsumerApplication.class, args);

		log.info("******************************************************");
		log.info("_________________Application Started__________________");
		log.info("******************************************************");
	}

}
