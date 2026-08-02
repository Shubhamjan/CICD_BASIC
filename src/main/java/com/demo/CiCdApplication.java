package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CiCdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiCdApplication.class, args);
		log.info("CiCd Practices");
	}

}
