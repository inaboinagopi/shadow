package com.shadowapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("bearer-key")) // 🔹 Apply security globally
                .addServersItem(new Server().url("https://reportsapi.scaits.net/"))
                .addServersItem(new Server().url("https://testreportsapi.scaits.net/"))
                .addServersItem(new Server().url("http://localhost:8082/"))
                .addServersItem(new Server().url("https://web.scaits.net/"))
                .addServersItem(new Server().url("http://10.10.1.116:8080/"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Authorization"))) // 🔹 Ensure it's added to the "Authorization" header
                .info(new Info()
                        .title("Scaits Micro Service")
                        .description("Manage All Scaits micro Services")
                        .termsOfService("")
                        .version("1.0.0")
                        .license(new License().name("").url("http://unlicense.org"))
                        .contact(new io.swagger.v3.oas.models.info.Contact().email("maheshkumar.g@varsitymgmt.com")));
    }
}
