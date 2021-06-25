package com.mrozowski.requestprocessor.datasource;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
class ResultDatasource implements ResultRepository{

  private static final List<ResultEntity> RESULT_DATA = new ArrayList<>();

  @Override
  public void add(ResultEntity entity) {
    RESULT_DATA.add(entity);
  }

  @Override
  public Optional<ResultEntity> findByRequestId(UUID requestId) {
    return RESULT_DATA.stream()
        .filter(e->e.getRequestId().equals(requestId))
        .findFirst();
  }

}
