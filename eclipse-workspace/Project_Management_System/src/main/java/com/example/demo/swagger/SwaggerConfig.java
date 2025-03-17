package com.example.demo.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

public class SwaggerConfig {
	
public OpenAPI customOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
						.title("Project Management API")
						.description("API documentation for Student Login ,Registration")
						.version("2.6.0")
						.contact(new Contact()
								.name("Pratiksha R.R")
								.email("praturaj06@gmail.com")
								.url("https://google.com"))
						);
}

}
