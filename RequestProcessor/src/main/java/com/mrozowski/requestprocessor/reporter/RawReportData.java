package com.mrozowski.requestprocessor.reporter;

import lombok.Builder;
import lombok.Value;

import com.mrozowski.requestprocessor.utils.Decision;

import java.time.LocalDateTime;
import java.util.Date;

@Value
@Builder
public class RawReportData {
  String name;
  Decision decision;
  LocalDateTime requestDate;
  LocalDateTime resultDate;
}
