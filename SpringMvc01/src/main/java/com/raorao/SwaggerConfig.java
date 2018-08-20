package com.raorao;

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
    public Docket createRestApi() {
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SpringMVC中使用Swagger2整合").termsOfServiceUrl("https://git.oschina.net/suntea")
                .contact(new Contact("我的博客", "https://www.cnblogs.com/raorao1994/", "lxh9788@qq.com")).version("1.0.0").build();
    }
}
