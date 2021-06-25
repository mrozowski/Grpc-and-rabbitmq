package com.mrozowski.requestprocessor.datasource;

import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class ResultEntity {
  UUID id;
  UUID requestId;
  String result;
  Date date;
}
