package com.mediscreen.risk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.mediscreen.risk.proxies")
public class RiskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskApplication.class, args);
	}

}
