package com.assolutoRacing.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AssolutoRacingBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssolutoRacingBatchApplication.class, args);
	}

}
