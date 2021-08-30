package com.userService.usermicroservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class swaggerConfig {

	public Docket swaggerConfig() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("My REST API", "DEPARTMENT description of API.", "1.0", "Terms of service",
				new Contact("Ebin B", "", "ebinb11@gmail.com"), "License of API", "API license URL",
				Collections.emptyList());
	}

}
