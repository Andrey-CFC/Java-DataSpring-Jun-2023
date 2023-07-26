package com.example.SpringRepositories.config;


import org.springframework.core.env.Environment;

@org.springframework.context.annotation.Configuration
public class Configuration {
    private Environment environment;

//    public Configuration(Environment environment) {
//        this.environment = environment;
//
//        int property = this.environment.getProperty("com.example.max-shampoos",int.class);
//
//        System.out.println(property);
//    }
}
