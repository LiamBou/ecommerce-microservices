package com.example.testserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TestServApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestServApplication.class, args);
    }

}
