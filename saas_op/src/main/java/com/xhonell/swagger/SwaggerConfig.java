package com.xhonell.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * program: saas
 * ClassName SwaggerConfig
 * description:
 * author: xhonell
 * create: 2025年01月22日15时23分
 * Version 1.0
 **/
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 处理器方法需要有ApiOperation注解才能生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 路径使用any风格
                .paths(PathSelectors.any())
                .build()
                // 如何保护我们的Api，有三种验证（ApiKey, BasicAuth, OAuth）
                .securitySchemes(security())
                .apiInfo(apiInfo());
    }

    //配置在请求的接口头中统一携带token
    private List<ApiKey> security() {
        ArrayList<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("token", "token", "header"));
        return apiKeys;
    }

    /**
     * 接口文档信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("智能科技saas运营平台")
                .description("智能科技saas运营平台接口文档")
                .version("V1.0")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build();
    }
}
