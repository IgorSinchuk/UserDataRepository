package com.igorsinchuk.datarepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.igorsinchuk.datarepository")
@EnableJpaRepositories(basePackages = "com.igorsinchuk.datarepository.repository")
@EntityScan(basePackages = "com.igorsinchuk.datarepository.model")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
