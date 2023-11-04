package com.microservice.store;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableFeignClients
public class AppConfig {

	@Bean("clientRest")
	public RestTemplate registrarRestTemplate () {
		return new RestTemplate () ;
	}
}
