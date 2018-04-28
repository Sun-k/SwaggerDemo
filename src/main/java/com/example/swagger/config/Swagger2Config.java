package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sunk
 * @create 2018-4-28-9:03
 **/

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private ApiInfo aipInfo(){

        return new ApiInfoBuilder()
                .title("Swagger-UI ")
                .description("Swagger2Demo")
                .termsOfServiceUrl("#")
                .contact(new Contact("Sunk","#","sunkkkkkkkkk@iclod.com"))
                .version("1.0")
                .build();
    }

    private Tag[] getTags(){
        Tag[] tags = {
                new Tag("接口","接口相关说明")
        };
        return tags;
    }


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(aipInfo())
                .tags(new Tag("接口名称","接口描述"),getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.Controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
