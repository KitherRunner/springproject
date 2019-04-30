package com.kither.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
@EnableWebMvc
@ComponentScan("com.kither")
@MapperScan("com.kither.mapper")
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.kither"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("动态配置自动任务")
                .description("动态配置自动任务")
                .contact(new Contact("kither", "www.kither.com", "kither@gmail.com"))
                .version("1.0")
                .build();
    }

}
