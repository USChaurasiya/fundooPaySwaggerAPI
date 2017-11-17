package com.bridgelabz.fundooPay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
@Configuration
@EnableSwagger2

public class ApplicationConfig extends WebMvcConfigurerAdapter {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(getApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.fundooPay.controller"))
	                .paths(PathSelectors.any())
	                .build();
	    }
	 private Predicate<String> postPaths() {
			return or(regex("/serviceprovider.*"));
		}


	    private ApiInfo getApiInfo() {
	        Contact contact = new Contact("BridgeLabz Solution","","admin@bridgelabz.com");
	        return new ApiInfoBuilder()
	                .title("FundooPay Swagger API")
	                .description("Swagger API for FundooPap Application")
	                .version("1.0.0")
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
	                .contact(contact)
	                .build();
	    }
	    @Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}

}
