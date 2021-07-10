package com.mrozowski.requestprocessor.reporter;

import lombok.RequiredArgsConstructor;

import com.mrozowski.requestprocessor.utils.DateHelper;
import com.mrozowski.study.grpc.api.v1.ReporterService.Decision;
import com.mrozowski.study.grpc.api.v1.ReporterService.ReportData;

import static com.mrozowski.requestprocessor.utils.DateHelper.getTimestamp;


@RequiredArgsConstructor
public class ReportFacade {

  private final ReportMessageSender reportMessageSender;

  public void send(RawReportData rawReportData) {
    var messageObject = createReportDataObject(rawReportData);
    reportMessageSender.send(messageObject);
  }

  private ReportData createReportDataObject(RawReportData rawReportData) {
    return ReportData.newBuilder()
        .setRequestName(rawReportData.getName())
        .setDecision(getDecision(rawReportData))
        .setRequestDate(getTimestamp(rawReportData.getRequestDate()))
        .setResultDate(getTimestamp(rawReportData.getResultDate()))
        .build();
  }

  private Decision getDecision(RawReportData data) {
    var stringDecision = data.getDecision().name();
    return Decision.valueOf(stringDecision);
  }

}
