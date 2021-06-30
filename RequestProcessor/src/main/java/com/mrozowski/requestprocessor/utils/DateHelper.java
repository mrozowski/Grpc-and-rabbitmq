package com.mrozowski.requestprocessor.utils;

import lombok.experimental.UtilityClass;

import com.google.protobuf.Timestamp;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateHelper {

  private final static String DATA_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss.SSS";

  public static LocalDateTime toDate(Timestamp timestamp){
    return Instant
        .ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos())
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
  }

  public static String toStringData(LocalDateTime date){
    var formatter = DateTimeFormatter.ofPattern(DATA_TIME_FORMAT);
    return date.format(formatter);
  }

  public static Timestamp getTimestamp(LocalDateTime date) {
    return Timestamp.newBuilder()
        .setSeconds(date.toEpochSecond(OffsetDateTime.now().getOffset()))
        .setNanos(date.getNano())
        .build();
  }
}
