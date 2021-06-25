package com.mrozowski.requestprocessor.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.UUID;

@Configuration
class DatasourceConfiguration {

  @Bean
  ResultRepository resultRepository(){
    var resultDatasource = new ResultDatasource();
    resultDatasource.add(ResultEntity.builder()
        .id(UUID.randomUUID())
        .requestId(UUID.fromString("31f8788c-78e1-4bc3-b651-a9ad0853ada9"))
        .date(new Date())
        .result("someResult")
        .build());
    return resultDatasource;
  }
}
