package com.mrozowski.bridge.result;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GetResultUseCase {

  private final ResultReceiver resultReceiver;

  public ResultDto getResult(UUID id) {
    return resultReceiver.receive(id);
  }
}
