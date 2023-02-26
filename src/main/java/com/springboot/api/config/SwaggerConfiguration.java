package com.springboot.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private static final String API_NAME = "Spring Boot Open API Test with Swagger";
    private static final String API_VERSION = "1.0.0";
    private static final String API_DESCRIPTION = "스프링부트 API 설명서";
    private static final String API_BASEPACKAGE = "com.springboot.api";

    @Bean
    public Docket api(){
        Parameter parameterBuilder = new ParameterBuilder()
            .name(HttpHeaders.AUTHORIZATION)
            .description("ACCESS TOKEN")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build();

        List<Parameter> globalParameters = new ArrayList<>();
        globalParameters.add(parameterBuilder);

        return new Docket(DocumentationType.SWAGGER_2)
            .globalOperationParameters(globalParameters)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage(API_BASEPACKAGE))
            .paths(PathSelectors.any())
            .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(API_NAME)
            .description(API_DESCRIPTION)
            .version(API_VERSION)
            .build();
    }
}
