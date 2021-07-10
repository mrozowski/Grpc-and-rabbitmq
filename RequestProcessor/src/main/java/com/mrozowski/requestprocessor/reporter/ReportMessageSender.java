package com.mrozowski.requestprocessor.reporter;

import com.mrozowski.study.grpc.api.v1.ReporterService.ReportData;

public interface ReportMessageSender {

  void send(ReportData message);
}
