package com.example.myspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.myspringdatajpa")
public class MySpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringDataJpaApplication.class, args);
    }

}
