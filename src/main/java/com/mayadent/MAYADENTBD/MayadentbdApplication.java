package com.mayadent.MAYADENTBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MayadentbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MayadentbdApplication.class, args);
	}

}
