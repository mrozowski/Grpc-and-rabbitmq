package com.mrozowski.requestprocessor.grpc;

import lombok.RequiredArgsConstructor;

import com.mrozowski.study.grpc.api.v1.BridgeServiceGrpc.BridgeServiceBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class GrpcConfiguration {

  @GrpcClient("bridge-service")
  private BridgeServiceBlockingStub blockingStub;

  @Bean
  BridgeServiceAdapter bridgeServiceAdapter(){
    return new BridgeServiceAdapter(blockingStub);
  }
}
