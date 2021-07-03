package com.mrozowski.bridge.result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.mrozowski.bridge.grpc.ServiceNotAvailableException;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class GetResultUseCase {

  private final ResultReceiver resultReceiver;

  public ResultDto getResult(UUID id) {
    try{
      return resultReceiver.receive(id);

    } catch (StatusRuntimeException e) {
      if (e.getStatus() == Status.NOT_FOUND)
        throw new ResultNotFoundException("Result not Found");
      else if (e.getStatus().getCode() == Code.UNAVAILABLE)
        throw new ServiceNotAvailableException("RP service not available");
      else
        throw new IllegalStateException(e);
    }
  }
}
