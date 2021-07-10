package com.mrozowski.requestprocessor.processor;

import lombok.RequiredArgsConstructor;

import com.mrozowski.requestprocessor.datasource.ResultRepository;
import com.mrozowski.requestprocessor.reporter.ReportFacade;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class ProcessorConfiguration {

  private final ResultRepository resultRepository;
  private final ApplicationEventPublisher eventPublisher;
  private final RequestProcessNotifier notifier;
  private final ReportFacade reportFacade;

  @Bean
  RequestProcessor requestProcessor(){
    return new RequestProcessor(resultRepository, eventPublisher);
  }

  @Bean
  RequestProcessorListener requestProcessorListener(){
    return new RequestProcessorListener(notifier, resultRepository, reportFacade);
  }
}
