package com.gbabler.javakafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class JavaKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaKafkaApplication.class, args);
	}

}
