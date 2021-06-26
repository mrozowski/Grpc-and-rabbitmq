package com.mrozowski.requestprocessor.grpc;

import lombok.RequiredArgsConstructor;

import com.mrozowski.requestprocessor.processor.RequestProcessNotifier;
import com.mrozowski.study.grpc.api.v1.BridgeServiceGrpc.BridgeServiceBlockingStub;
import com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier;

import java.util.UUID;

import static java.util.concurrent.TimeUnit.SECONDS;

@RequiredArgsConstructor
class BridgeServiceAdapter implements RequestProcessNotifier {

  private final BridgeServiceBlockingStub stub;

  @Override
  public void notifyProcessCompleted(UUID requestId) {
    getStub().notifyRequestDone(RequestIdentifier.newBuilder()
        .setId(requestId.toString())
        .build());
  }

  private BridgeServiceBlockingStub getStub() {
    return stub.withDeadlineAfter(7, SECONDS);
  }
}
