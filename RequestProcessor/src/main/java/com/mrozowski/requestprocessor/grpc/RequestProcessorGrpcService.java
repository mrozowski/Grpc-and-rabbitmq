package com.mrozowski.requestprocessor.grpc;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.mrozowski.requestprocessor.datasource.ResultEntity;
import com.mrozowski.requestprocessor.datasource.ResultRepository;
import com.mrozowski.requestprocessor.processor.Processor;
import com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request;
import com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier;
import com.mrozowski.study.grpc.api.v1.RequestProcessor.Result;
import com.mrozowski.study.grpc.api.v1.RequestProcessorServiceGrpc.RequestProcessorServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@GrpcService
@RequiredArgsConstructor
class RequestProcessorGrpcService extends RequestProcessorServiceImplBase {

  private final ResultRepository resultRepository;
  private final Processor processor;

  @Override
  public void processRequest(
      Request request,
      StreamObserver<Empty> responseObserver) {
    processor.process(request);
    log.info("Request with id: {} received", request.getId());

    responseObserver.onNext(Empty.newBuilder().build());
    responseObserver.onCompleted();
  }

  @Override
  public void getResult(
      RequestIdentifier request,
      StreamObserver<Result> responseObserver) {

    var requestId = UUID.fromString(request.getId());
    var resultEntity = resultRepository.findByRequestId(requestId);

    if (resultEntity.isPresent()) {
      Result result = createResponse(resultEntity.get());
      responseObserver.onNext(result);
      responseObserver.onCompleted();

      log.info("Result with id: {} sent", resultEntity.get().getId());
    } else {
      log.warn("Result with id: {} not found", request.getId());
    }

  }

  private Result createResponse(ResultEntity result) {
    Instant instant = result.getDate().toInstant();
    return Result.newBuilder()
        .setId(result.getId().toString())
        .setRequestId(result.getRequestId().toString())
        .setResult(result.getResult())
        .setDate(Timestamp.newBuilder()
            .setSeconds(instant.getEpochSecond())
            .setNanos(instant.getNano())
            .build())
        .build();
  }
}
