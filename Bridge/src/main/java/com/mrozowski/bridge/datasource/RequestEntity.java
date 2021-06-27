package com.mrozowski.bridge.datasource;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class RequestEntity {

  UUID id;
  String name;
  String request;
  RequestStatus status;
  LocalDateTime date;
}
