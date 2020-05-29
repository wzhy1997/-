package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wzhy.mapper")
public class PiclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiclassApplication.class, args);
    }

}
