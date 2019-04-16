package com.lambdaschool.todos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
      .apis(RequestHandlerSelectors.basePackage("com.lambdaschool.todos"))
      .paths(PathSelectors.regex("/.*"))
      .build().apiInfo(apiEndPointsInfo());
  }

  private ApiInfo apiEndPointsInfo() {
    return new ApiInfoBuilder().title("Todos Project")
      .description("CRUD Todos App")
      .contact(new Contact("John O'Rourke", "https://johnoro.netlify.com/", "officialjohnorourke@gmail.com"))
      .license("MIT")
      .licenseUrl("https://github.com/johnoro/java-todos/blob/master/LICENSE")
      .version("0.0.1")
      .build();
  }
}
