package com.hybrid.orchestration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrchestrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrchestrationApplication.class, args);
    }
}
