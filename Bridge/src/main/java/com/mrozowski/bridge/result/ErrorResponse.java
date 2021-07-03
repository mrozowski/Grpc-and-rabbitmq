package com.mrozowski.bridge.result;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
class ErrorResponse {
  String error;
  String message;
  int status;
  LocalDateTime timestamp;
}
