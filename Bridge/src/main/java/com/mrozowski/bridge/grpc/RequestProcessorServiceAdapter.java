package com.mrozowski.bridge.grpc;

import lombok.RequiredArgsConstructor;

import com.mrozowski.bridge.datasource.RequestEntity;
import com.mrozowski.bridge.request.RequestSender;
import com.mrozowski.bridge.result.ResultDto;
import com.mrozowski.bridge.result.ResultReceiver;
import com.mrozowski.bridge.utils.DateHelper;
import com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request;
import com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.RequestIdentifier;
import com.mrozowski.study.grpc.api.v1.RequestProcessor.Result;
import com.mrozowski.study.grpc.api.v1.RequestProcessorServiceGrpc.RequestProcessorServiceBlockingStub;

import java.util.UUID;

import static java.util.concurrent.TimeUnit.SECONDS;

@RequiredArgsConstructor
class RequestProcessorServiceAdapter implements RequestSender, ResultReceiver {

  private final RequestProcessorServiceBlockingStub serviceBlockingStub;

  @Override
  public void send(RequestEntity requestEntity) {
    var request = createRequest(requestEntity);

    getStub().processRequest(request);
  }

  @Override
  public ResultDto receive(UUID id) {
    Result result = getStub().getResult(RequestIdentifier.newBuilder()
        .setId(id.toString())
        .build());

    return ResultDto.builder()
        .id(UUID.fromString(result.getId()))
        .requestId(UUID.fromString(result.getRequestId()))
        .result(result.getResult())
        .date(DateHelper.toDate(result.getDate()))
        .build();
  }

  private static Request createRequest(RequestEntity requestEntity) {
    return Request.newBuilder()
        .setId(requestEntity.getId().toString())
        .setName(requestEntity.getName())
        .setRequest(requestEntity.getRequest())
        .setDate(DateHelper.getTimestamp(requestEntity.getDate()))
        .build();
  }

  private RequestProcessorServiceBlockingStub getStub(){
    return serviceBlockingStub.withDeadlineAfter(7, SECONDS);
  }
}
