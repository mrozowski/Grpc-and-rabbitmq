package com.mrozowski.bridge.request;

import lombok.RequiredArgsConstructor;

import com.mrozowski.bridge.datasource.RequestEntity;
import com.mrozowski.bridge.datasource.RequestRepository;
import com.mrozowski.bridge.datasource.RequestStatus;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class GetRequestInfoUseCase {

  private final RequestRepository requestRepository;

  public Optional<RequestEntity> getRequest(UUID id){
    return requestRepository.findById(id);
  }

  public RequestStatus getStatus(UUID id){
    return requestRepository.getStatus(id);
  }
}
