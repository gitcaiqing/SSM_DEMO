package com.ssm.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2文档构建配置类
 * @author 
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Config {
	
	//接口文档构建配置
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			//.apis(RequestHandlerSelectors.any()) 所有的接口
			//指定扫描的路径
			//.apis(RequestHandlerSelectors.basePackage("com.ssm.restapi"))
			.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
			.build()
			.apiInfo(apiInfo());
	}

	//接口文档信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        	.title("SSM_DEMO-RESTFul API接口服务列表")
        	.description("")
        	.termsOfServiceUrl("http://192.168.100.104:7080")
        	.version("1.0")
        	.build();
    }
}
