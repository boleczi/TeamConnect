package pl.piotrdutkiewicz.teamconnect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	private static final Logger logger = LogManager.getLogger(TeamConnectController.class);
	
	@Bean
	 public Docket productApi() {
	 return new Docket(DocumentationType.SWAGGER_2)
	 .apiInfo(metaData())
	 .select()
	 .apis(RequestHandlerSelectors.any())
	 .paths(PathSelectors.any())
	 .build();
	
	 }
	
	
	private ApiInfo metaData() {
		
		logger.debug(" ApiInfo metaData()____________________");
		return new ApiInfo(
			      "My REST API", 
			      " API.", 
			      "API TOS", 
			      "Terms of service", 
			      new Contact("Piotr Dutkiewicz", "www.example.com", "piotr.dutkiewicz1@gmail.com"), 
			      "License of API", "API license URL", new ArrayList<VendorExtension>());
        
	}
	
	
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}

