package com.itgroup.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DataServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(DataServiceApp.class, args);
    }
}
