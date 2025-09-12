package com.example.springbootelplus2025;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ServletComponentScan
@SpringBootApplication
@MapperScan("com.example.springbootelplus2025.mapper")
public class SpringBootElplus2025Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElplus2025Application.class, args);
    }

}
