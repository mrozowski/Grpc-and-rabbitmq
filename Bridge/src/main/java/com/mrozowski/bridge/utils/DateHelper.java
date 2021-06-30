package com.mrozowski.bridge.utils;

import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class DateHelper {

  public static Timestamp getTimestamp(LocalDateTime date) {
    return Timestamp.newBuilder()
        .setSeconds(date.toEpochSecond(OffsetDateTime.now().getOffset()))
        .setNanos(date.getNano())
        .build();
  }

  public static LocalDateTime toDate(Timestamp date) {
    return Instant
        .ofEpochSecond(date.getSeconds(), date.getNanos())
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
  }
}
