package com.projetoPapelaria.Papelaria.config;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
  @Bean
  public OpenAPI myOpenAPI() {
   
    Contact contact = new Contact() {
		
		@Override
		public Class<? extends Annotation> annotationType() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String url() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String name() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Extension[] extensions() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String email() {
			// TODO Auto-generated method stub
			return null;
		}
	};
    //contact.setEmail("medeiros.ph@gmail.com");
    //contact.setName("Raphael Medeiros");
    //contact.setUrl("https://www.mundomacintosh.com");


    Info info = new Info()
        .title("Papelaria API")
        .version("1.0")
        //.contact(contact)
        .description("Raphael Medeiros\n"+"\n"+ "medeiros.ph@gmail.com\n"+"\n"+ "Projeto Papelaria API.");

    return new OpenAPI().info(info);
  }
}

