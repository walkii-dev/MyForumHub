package com.educational.MyForumHub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                                .title("My Forum Hub API")
                                .description("O My Forum Hub é a minha versão do Challenge proposto pela Alura." +
                                        " é uma API Rest que fornece as funcionalidades de fórum, com tópicos" +
                                        " e respostas dos usuários.")
                                .contact(new Contact()
                                        .name("Walkii-dev")
                                        .url("https://github.com/walkii-dev")));

    }
}