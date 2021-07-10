package com.mrozowski.reporter.report;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class ReportUseCaseConfiguration {

  private final ReportRepository repository;

  @Bean
  GetReportUseCase getReportUseCase(){
    return new GetReportUseCase(repository);
  }

  @Bean
  SaveReportUseCase saveReportUseCase(){
    return new SaveReportUseCase(repository);
  }
}
