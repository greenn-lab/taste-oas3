package com.example.tasteoas;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

  public static final String BEARER = "Bearer";

  @Bean
  public Docket api() {
    return new Docket(
        DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .securityContexts(List.of(this.securityContext()))
        .securitySchemes(List.of(apiKey()))
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();

  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "SORIZAVA REST API",
        "Some custom description of API.",
        "1.0",
        "Terms of service",
        new Contact("sorizava", "www.sorizava.com", "sorizava@sorizava.co.kr"),
        "License of API",
        "API license URL",
        Collections.emptyList());
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        .build();
  }


  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;

    return List.of(new SecurityReference(BEARER, authorizationScopes));
  }

  private ApiKey apiKey() {
    return new ApiKey(BEARER, BEARER, "header");
  }

}
