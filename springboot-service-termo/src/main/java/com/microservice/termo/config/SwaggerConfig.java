package com.microservice.termo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.microservice.termo.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}

    private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Termo",
				"Microservicio para creacion de termos",
				"0.0.1",
				"Terminos de servicios",
				new Contact("Angel", "url", "angeltapia1805@gmail.com"),
				"License",
				"License url",
				Collections.emptyList()
				);
				
	}
}
