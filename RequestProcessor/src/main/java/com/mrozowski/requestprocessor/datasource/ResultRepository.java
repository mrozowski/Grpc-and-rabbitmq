package com.mrozowski.requestprocessor.datasource;

import java.util.Optional;
import java.util.UUID;

public interface ResultRepository {

  void add(ResultEntity entity);

  Optional<ResultEntity> findByRequestId(UUID requestId);
}
