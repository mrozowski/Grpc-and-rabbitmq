package com.mrozowski.bridge.result;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class ResultDto {

  UUID id;
  UUID requestId;
  String result;
  LocalDateTime date;
}
