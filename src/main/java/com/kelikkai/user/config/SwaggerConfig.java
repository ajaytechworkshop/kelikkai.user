package com.kelikkai.user.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{

	/** The swagger flag. */
	@Value("${swagger.flag}")
	private String swaggerFlag;

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo()
	{
		return new ApiInfo("REST APIs for Kelikkai User service",
				"This WebUI describe the REST APIs that can be used to manipulate the 'User' service", "v2.0",
				"Terms of service", "", "License of API", "API license URL");
	}
}
