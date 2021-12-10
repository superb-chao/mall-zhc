package com.example.mallzhc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 配置了Swagger 的Docket的bean实例,扫描接口的位置
 * .apis
 * RequestHandlerSelectors 配置swagger扫描接口的方式
 * basePackage() 指定要扫描哪些包
 * any() 全部都扫描
 * none() 全部不扫描
 * withClassAnnotation() 扫描类上的注解 参数是一个注解的反射对象
 * withMethodAnnotation() 扫描包上的注解
 * .paths
 * PathSelectors 路径扫描接口
 * ant 配置以xxx 开头的路径
 *
 * @return
 */


/**
 * Swagger2API文档的配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.example.mallzhc.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    //配置作者信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("mall")
                .contact("zhc")
                .version("1.0")
                .build();
    }
}
