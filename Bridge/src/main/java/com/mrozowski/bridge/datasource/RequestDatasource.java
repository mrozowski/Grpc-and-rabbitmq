package com.mrozowski.bridge.datasource;

import lombok.NonNull;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
class RequestDatasource implements RequestRepository{

  private static final List<RequestEntity> REQUEST_DATA = new ArrayList<>();

  @Override
  public void add(@NonNull RequestEntity requestEntity) {
    REQUEST_DATA.add(requestEntity);
  }

  @Override
  public void updateStatus(UUID id, RequestStatus status) {
    REQUEST_DATA.stream()
        .filter(e->e.getId().equals(id))
        .findFirst()
        .ifPresent(e->e.setStatus(status));
  }

  @Override
  public RequestStatus getStatus(UUID id) {
    var entity = findById(id);

    if (entity.isPresent()){
      return entity.get().getStatus();
    }
    else{
      throw new RequestNotFoundException();
    }
  }

  @Override
  public Optional<RequestEntity> findById(UUID id) {
    return REQUEST_DATA.stream()
        .filter(requestEntity -> requestEntity.getId().equals(id))
        .findFirst();
  }
}
