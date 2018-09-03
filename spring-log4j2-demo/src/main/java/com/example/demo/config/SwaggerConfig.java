package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                //.apis(RequestHandlerSelectors.withMethodAnnotation(ResponseBody.class))
	                .apis(RequestHandlerSelectors.basePackage("com"))
	                .paths(PathSelectors.any())
	                .build()
	                .enable(true)
	                .pathMapping("/");
	    }
	    
	    private ApiInfo apiInfo() {
	        Contact contact = new Contact(
	                "fenghao",
	                "http://",
	                "512");
	        return new ApiInfoBuilder()
	                .title("Swagger2")
	                .description("简单测试一下")
	                .version("1.0")
	                .contact(contact)
	                .build();
	    }
}
