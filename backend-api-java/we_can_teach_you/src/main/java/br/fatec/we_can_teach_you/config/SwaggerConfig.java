package br.fatec.we_can_teach_you.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI weCanTeachYouOpenAPI() {
        return new OpenAPI().info(new Info()
            .title("API do Projeto Finanças da FATEC") .description("We Can Teach You - API")
            .version("v0.0.1")
            .contact(new Contact()
                .name("Gabriel Castro da Silva | Gustavo Costa Arakaki | Luca Pedro de Oliveira").email("dev.gbcproject@gmail.com"))
            .license(new License()
            .name("Apache 2.0").url("http://springdoc.org")));
    }
}