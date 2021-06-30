package com.mrozowski.bridge.result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.mrozowski.bridge.datasource.RequestRepository;
import com.mrozowski.bridge.datasource.RequestStatus;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class NotificationReceivedUseCase {

  private final RequestRepository requestRepository;

  public void receive(UUID id) {
    requestRepository.updateStatus(id, RequestStatus.DONE);
    log.info("Result notification received. Id: {}", id);
  }
}
