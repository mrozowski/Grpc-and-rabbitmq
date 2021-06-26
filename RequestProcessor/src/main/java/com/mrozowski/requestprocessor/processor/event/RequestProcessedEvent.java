package com.mrozowski.requestprocessor.processor.event;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class RequestProcessedEvent {

  UUID requestId;
  String name;
  LocalDateTime requestDate;
}
