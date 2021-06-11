package com.bolsadeideas.springboot.app.infrastructure.mappers.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
            .info(new Info().title("CRUD API - H2")
                .version(appVersion)
                .contact(new Contact().name("Daniel Alfonso Fuentes López")
                    .url("https://github.com/dafulo22"))
                .description("This is a sample CRUD application using spring data")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}