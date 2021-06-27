package com.mrozowski.bridge.request;

import lombok.RequiredArgsConstructor;

import com.mrozowski.bridge.datasource.RequestEntity;
import com.mrozowski.bridge.datasource.RequestRepository;
import com.mrozowski.bridge.datasource.RequestStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
public class SaveRequestUseCase {

  private final RequestRepository requestRepository;

  public UUID save(UserRequest request) {
    validateRequest(request);
    var requestEntity = createRequestEntity(request);

    requestRepository.add(requestEntity);
    return requestEntity.getId();
  }

  private void validateRequest(UserRequest request) {
    if (request.getName().isBlank()) throw new IllegalArgumentException("Name cannot be empty");
    if (request.getRequest().isBlank()) throw new IllegalArgumentException("Request cannot be empty");
    if (request.getRequest().length() > 200) throw new IllegalArgumentException("Invalid request");
  }

  private RequestEntity createRequestEntity(UserRequest request) {
    return RequestEntity.builder()
        .id(UUID.randomUUID())
        .name(request.getName())
        .request(request.getRequest())
        .status(RequestStatus.PENDING)
        .date(LocalDateTime.now())
        .build();
  }
}
