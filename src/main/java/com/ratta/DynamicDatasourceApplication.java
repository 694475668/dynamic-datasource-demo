package com.ratta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 69447
 */
@SpringBootApplication
@MapperScan({"com.ratta.mapper"})
public class DynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceApplication.class, args);
    }

}
