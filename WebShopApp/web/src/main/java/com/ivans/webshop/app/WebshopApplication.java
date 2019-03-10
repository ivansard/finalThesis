package com.ivans.webshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ivans.webshop.repository."})
@EntityScan(basePackages = {"com.ivans.webshop.repository"})
@ComponentScan(basePackages = {"com.ivans.webshop"})
public class WebshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class);
    }
}
