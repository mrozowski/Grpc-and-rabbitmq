package com.mrozowski.requestprocessor.processor;

import lombok.RequiredArgsConstructor;

import com.mrozowski.requestprocessor.datasource.ResultRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class ProcessorConfiguration {

  private final ResultRepository resultRepository;
  private final ApplicationEventPublisher eventPublisher;
  private final RequestProcessNotifier notifier;

  @Bean
  RequestProcessor requestProcessor(){
    return new RequestProcessor(resultRepository, eventPublisher);
  }

  @Bean
  RequestProcessorListener requestProcessorListener(){
    return new RequestProcessorListener(notifier, resultRepository);
  }
}
