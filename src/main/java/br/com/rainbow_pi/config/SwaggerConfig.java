package br.com.rainbow_pi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customizarSwagger(){
		return new OpenAPI()
				.info(new Info()
						.title("PI - Rainbow")
						.version("v1")
						.description("API desenvolvida pelo grupo Rainbow como PI do projeto Transforme-se")
						.termsOfService("http://swagger.io/terms")
						.license(new License().name("Apache 2.0").url("http://springdoc.org%22"))
						);
				
		
		}

}
