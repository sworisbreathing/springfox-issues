package com.github.sworisbreathing.springfox.issues.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = "io.swagger.api")
@EnableWebMvc
@EnableSwagger2 //Loads the spring beans required by the framework
public class SwaggerConfiguration {

  @Bean
  ApiInfo apiInfo() {
    return new ApiInfo(
            "Sample Api",
            "A sample api",
            "1.0",
            "about:blank",
            (Contact) null,
            null,
            null);
  }

  @Bean
  public Docket docket(final ApiInfo apiInfo) {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo)
            .useDefaultResponseMessages(false)
            .select()
            .paths(Predicates.not(
                            Predicates.or(
                                    PathSelectors.regex("/error"), // Exclude Spring error controllers
                                    PathSelectors.regex("/management(/.*)?") // Exclude Spring management controllers
                            )))
            .build();
  }
}
