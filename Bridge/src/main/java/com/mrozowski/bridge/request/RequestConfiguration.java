package com.mrozowski.bridge.request;

import lombok.RequiredArgsConstructor;

import com.mrozowski.bridge.datasource.RequestEntity;
import com.mrozowski.bridge.datasource.RequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class RequestConfiguration {

  private final RequestRepository requestRepository;
  private final RequestSender requestSender = requestEntity -> { };

  @Bean
  SaveRequestUseCase saveRequestUseCase(){
    return new SaveRequestUseCase(requestRepository);
  }

  @Bean
  GetRequestInfoUseCase getRequestInfoUseCase(){
    return new GetRequestInfoUseCase(requestRepository);
  }

  @Bean
  RequestServiceListener requestServiceListener(){
    return new RequestServiceListener(requestRepository, requestSender);
  }
}
