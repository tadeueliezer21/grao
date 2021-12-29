package com.primo.grao.adapters.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.primo.grao.adapters.input"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfo(
                                "Eliézer Tadeu",
                                "API Grão",
                                "1.0",
                                "Contact",
                                new Contact(
                                        "Eliézer Tadeu da Silva",
                                        "https://www.linkedin.com/in/eli%C3%A9zertadeu17/",
                                        "silva.eliezertadeu@gmail.com"),
                                "Free to play",
                                "#", new ArrayList<>()
                        )
                );
    }


}
