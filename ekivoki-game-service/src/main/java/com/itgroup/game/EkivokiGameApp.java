package com.itgroup.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EkivokiGameApp {

    public static void main(String[] args) {
        SpringApplication.run(EkivokiGameApp.class, args);
    }
}