package com.mrozowski.bridge.datasource;

import java.util.Optional;
import java.util.UUID;

public interface RequestRepository {

  void add(RequestEntity requestEntity);

  void updateStatus(UUID id, RequestStatus status);

  RequestStatus getStatus(UUID id);

  Optional<RequestEntity> findById(UUID id);
}
