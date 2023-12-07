package br.com.escola.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info( new Info()
                        .title("API escola")
                        .description("Apí para gerenciamento Escolar")
                        .contact(new Contact().name("Elias Santana - Avohai Silva").email("eliasantanasilva@gmail.com - avohai.atos@gmail.com")).version("1.0.0"));
    }
}
