package com.mrozowski.bridge.grpc;

import lombok.RequiredArgsConstructor;

import com.mrozowski.study.grpc.api.v1.RequestProcessorServiceGrpc.RequestProcessorServiceBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class GrpcConfiguration {

  @GrpcClient("request-processor")
  private RequestProcessorServiceBlockingStub blockingStub;

  @Bean
  RequestProcessorServiceAdapter requestProcessorServiceAdapter(){
    return new RequestProcessorServiceAdapter(blockingStub);
  }
}
