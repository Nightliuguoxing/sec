package com.example.sec.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 21:19
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Configuration
public class DocsConfig {

    private static final String SECURITY_SCHEME_NAME = "Bearer ";

    @Bean
    public OpenAPI templateOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Template API")
                        .description("LUCIFER'S TEMPLATE API")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://github.com/Nightliuguoxing")))
                .externalDocs(new ExternalDocumentation()
                        .description("LUCIFER DOCS")
                        .url("https://docs.liuguoxing.top"))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

}