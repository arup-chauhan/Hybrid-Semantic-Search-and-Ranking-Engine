package com.hybrid.orchestration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Scheduled(cron = "0 */15 * * * *")
    public void monitorServices() {
        System.out.println("Orchestration heartbeat: validating service health...");
    }
}
