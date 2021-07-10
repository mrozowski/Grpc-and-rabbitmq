package com.mrozowski.reporter.report;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.google.protobuf.Timestamp;
import com.mrozowski.study.grpc.api.v1.ReporterService.ReportData;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

  private final ReportRepository repository;

  public void saveReport(ReportData reportData){
    var reportEntity = createReportEntity(reportData);

    repository.save(reportEntity);
    log.info("Report saved");
  }

  private ReportEntity createReportEntity(ReportData reportData) {
    return ReportEntity.builder()
        .requestName(reportData.getRequestName())
        .decision(Decision.valueOf(reportData.getDecision().toString()))
        .requestDate(toDate(reportData.getRequestDate()))
        .resultDate(toDate(reportData.getResultDate()))
        .build();
  }

  public static LocalDateTime toDate(Timestamp timestamp){
    return Instant
        .ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos())
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime();
  }
}
