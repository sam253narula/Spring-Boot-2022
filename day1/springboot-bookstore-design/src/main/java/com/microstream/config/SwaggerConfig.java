package com.microstream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("BootStore-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.microstream.controller")).build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("BookStore API").description("BookStore API referance for developers")
				.termsOfServiceUrl("http://bookstore.com")
				.contact(new Contact("BookStore API", "http://bookstore.com", "bookstore@gmail.com"))
				.license("Book Store License").licenseUrl("http://bookstore.com").version("1.0").build();
	}

}
