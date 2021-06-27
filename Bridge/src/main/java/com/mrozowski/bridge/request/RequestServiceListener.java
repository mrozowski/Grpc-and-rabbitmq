package com.mrozowski.bridge.request;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.mrozowski.bridge.datasource.RequestRepository;
import com.mrozowski.bridge.datasource.RequestStatus;
import com.mrozowski.bridge.request.event.RequestSavedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@Slf4j
@RequiredArgsConstructor
class RequestServiceListener {

  private final RequestRepository requestRepository;
  private final RequestSender requestSender;

  @Async
  @EventListener
  public void onRequestSaved(RequestSavedEvent event){
    var entity = requestRepository.findById(event.getId());

    requestSender.send(entity.get());
    log.info("Request {} sent to processing service", event.getId());

    requestRepository.updateStatus(event.getId(), RequestStatus.PROCESSING);
  }
}
