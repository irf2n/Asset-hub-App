package com.allocator.asset_hub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Asset Hub - Allocation Management API")
                        .version("1.0.0")
                        .description("RESTful API engine for allocating corporate hardware assets and workspace desks.")
                        .contact(new Contact()
                                .name("Asset Hub Engineering Team")
                                .email("support@assethub.local")));
    }
}