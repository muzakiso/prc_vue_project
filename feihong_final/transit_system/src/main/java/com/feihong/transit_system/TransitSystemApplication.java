package com.feihong.transit_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.feihong.transit_system.mapper")
public class TransitSystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(TransitSystemApplication.class, args);
    }

}
