package com.mrozowski.requestprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RequestProcessorApplication {

  public static void main(String[] args) {
    SpringApplication.run(RequestProcessorApplication.class, args);
  }

}
