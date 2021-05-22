package com.gokibe.facejs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.gokibe.facejs.dao")
@SpringBootApplication
public class FacejsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacejsApplication.class, args);
    }

}
