package com.epipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.epipe")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
