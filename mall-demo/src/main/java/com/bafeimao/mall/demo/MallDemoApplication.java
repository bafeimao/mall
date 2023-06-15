package com.bafeimao.mall.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YouChuande
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library APIS",version = "1.0",description = "library apis"))
public class MallDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallDemoApplication.class, args);
    }

}
