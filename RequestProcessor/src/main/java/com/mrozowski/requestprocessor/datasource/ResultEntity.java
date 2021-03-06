package com.mrozowski.requestprocessor.datasource;

import lombok.Builder;
import lombok.Value;

import com.mrozowski.requestprocessor.utils.Decision;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class ResultEntity {
  UUID id;
  UUID requestId;
  String result;
  Decision decision;
  LocalDateTime date;
}
