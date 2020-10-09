package com.bhhan.eventsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventSampleApplication.class, args);
    }

}
