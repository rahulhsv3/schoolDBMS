package com.brillio.myfirstrestservice;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class MyfirstrestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstrestserviceApplication.class, args);
	}

}
