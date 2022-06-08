package br.com.softnunes.cadastroclientes.infrastructure.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    
	/*
	 * Configura o Swagger
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.softnunes.cadastroclientes"))
		.build()
		.apiInfo(metaInfo());
	}
	
	  private ApiInfo metaInfo() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Cadastro de Clientes",
	                "API REST para Gerenciamento de clientes.",
	                "1.0.0",
	                "Terms of Service",
	                new Contact("Rogério Nunes", "https://www.github.com/rogeriornunes",
	                        "rogerioricardonunes@gmail.com"),
	                "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
	        );
	        return apiInfo;
	    }
	  
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}