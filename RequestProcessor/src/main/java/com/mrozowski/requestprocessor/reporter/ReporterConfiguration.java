package com.mrozowski.requestprocessor.reporter;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class ReporterConfiguration {

  private final ReportMessageSender reportMessageSender;

  @Bean
  ReportFacade reportFacade(){
    return new ReportFacade(reportMessageSender);
  }
}
