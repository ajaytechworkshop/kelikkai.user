package com.kelikkai.user.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author PDN7KOR
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {  
	
	@Value("${swagger.flag}")
	private String swaggerFlag;
	
    /**
     * @return
     */
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        .groupName("User")
        .apiInfo(apiInfo()).enable(Boolean.valueOf(true))
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.kelikkai.user.controller"))
        .paths(regex("/.*"))
        .build();                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "REST APIs for the Kelikkai User service",
          "This WebUI describe the REST APIs that can be used to manipulate the 'User' service",
          "v2.0",
          "Terms of service",
          new Contact("Ajay Kumar", "", "ajaytechworkshop@gmail.com"),
          "License of API",
          "API license URL");
    }
}
