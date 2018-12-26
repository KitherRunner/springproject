package com.kingdee.configuration;

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

import javax.print.Doc;

@Configuration
@EnableSwagger2
// 配置@EnableWebMvc注解才可以访问到swagger-ui.html，不然会一直提示输入正确的地址
@EnableWebMvc
// 告诉swagger去那些包下面扫描注解(不配置的话一个接口都找不到)
@ComponentScan("com.kingdee")
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.kingdee.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().version("1.0").contact(new Contact("kither", "kither.com", "kither@163.com")).title("SSM-DRUID").description("ssm整合druid和swagger").build();
    }
}
