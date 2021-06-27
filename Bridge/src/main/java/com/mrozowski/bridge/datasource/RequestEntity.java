package com.mrozowski.bridge.datasource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class RequestEntity {

  private final UUID id;
  private final String name;
  private final String request;
  private final LocalDateTime date;
  @Setter private RequestStatus status;
}
