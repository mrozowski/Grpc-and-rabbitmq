package com.mrozowski.bridge.grpc;

import lombok.RequiredArgsConstructor;

import com.google.protobuf.Empty;
import com.mrozowski.bridge.result.NotificationReceivedUseCase;
import com.mrozowski.study.grpc.api.v1.BridgeServiceGrpc.BridgeServiceImplBase;
import com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier;
import io.grpc.stub.StreamObserver;;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
class BridgeGrpcService extends BridgeServiceImplBase {

  private final NotificationReceivedUseCase notificationReceivedUseCase;

  @Override
  public void notifyRequestDone(RequestIdentifier request, StreamObserver<Empty> responseObserver) {
    notificationReceivedUseCase.receive(UUID.fromString(request.getId()));

    responseObserver.onNext(Empty.newBuilder().build());
    responseObserver.onCompleted();
  }
}
