package com.mrozowski.requestprocessor.processor;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class RequestData {
  UUID id;
  String name;
  String request;
  LocalDateTime date;
}
