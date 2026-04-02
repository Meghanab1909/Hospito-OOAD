package com.hospito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hospito")
public class HospitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitoApplication.class, args);
    }
}