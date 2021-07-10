package com.mrozowski.bridge.result;

import lombok.RequiredArgsConstructor;

import com.mrozowski.bridge.datasource.RequestRepository;
import com.mrozowski.bridge.request.GetRequestInfoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class ResultConfiguration {

  private final RequestRepository requestRepository;
  private final ResultReceiver resultReceiver;
  private final GetRequestInfoUseCase getRequestInfoUseCase;

  @Bean
  NotificationReceivedUseCase notificationReceivedUseCase() {
    return new NotificationReceivedUseCase(requestRepository);
  }

  @Bean
  GetResultUseCase getResultUseCase() {
    return new GetResultUseCase(resultReceiver, getRequestInfoUseCase);
  }
}
