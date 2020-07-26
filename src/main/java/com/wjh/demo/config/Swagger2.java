package com.wjh.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

/**
 * swagger2文档配置
 *
 * @author Wen Jiahu
 * @create 2019-05-28 12:18
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi(Environment environment) {
        boolean isProd = "prod".equals(environment.getProperty("spring.profiles.active"));
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfo())
//                .ignoredParameterTypes(LoginUser.class)
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.wjh.demo.controller"))

                .paths(PathSelectors.any())
                .build();
        docket.enable(!isProd);
        docket.securitySchemes(newArrayList(
                new ApiKey("token", "token", "header")
        ));
        return docket;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("wjh", "https://www.baidu.com", null);
        return new ApiInfoBuilder()
                .title("wjh一个规范的spring boot示例程序")
                .contact(contact)
                .termsOfServiceUrl("http:127.0.0.1:8080")
                .version("1.0")
                .build();
    }
}
