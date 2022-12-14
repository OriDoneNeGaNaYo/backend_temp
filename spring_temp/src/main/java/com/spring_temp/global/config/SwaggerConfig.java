package com.spring_temp.global.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi Api() {
        return GroupedOpenApi.builder()
                .group("API")
                .pathsToMatch("/api/v0/**")
                .build();
    }

    @Bean
    public OpenAPI busOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("우리 동네 가나요?")
                        .description("우리 동네 가나요?의 API 입니다.")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("github link")
                        .url("https://github.com/OriDoneNeGaNaYo/backend_temp"));
    }

}