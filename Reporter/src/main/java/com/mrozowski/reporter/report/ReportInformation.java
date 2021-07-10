package com.mrozowski.reporter.report;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ReportInformation {

  int reportsNumber;
  double avgProcessTime;
  double maxProcessTime;
  double minProcessTime;
  List<Topic> mostPopularRequests;
  List<ReportEntity> reports;
}
