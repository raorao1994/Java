package com.pushshow.weixin.utility;
import com.google.common.base.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport; 

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList; 
 
@Configuration
@EnableSwagger2  
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket customDocket() {
        //
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("����", "https://www.baidu.me", "baidu_666@icloud.com");
        return new ApiInfo("Blogǰ̨API�ӿ�",//����� title
                "Swagger����demo",//С����
                "0.0.1",//�汾
                "www.baidu.com",//termsOfServiceUrl
                contact,//����
                "Blog",//������ʾ����
                "https://www.baidu.me"//��վ����
        );
    }
}