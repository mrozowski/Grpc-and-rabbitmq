package com.mrozowski.reporter.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mrozowski.reporter.report.SaveReportUseCase;
import com.mrozowski.study.grpc.api.v1.ReporterService.ReportData;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RequiredArgsConstructor
@RabbitListener(queues = "${reporter.messaging.result.queue}")
class ReportMessageListener {

  private final SaveReportUseCase saveReportUseCase;
  @RabbitHandler
  void listen(byte[] message) {
    try{
      log.info("Message retrieved from queue");

      var reportData = ReportData.parseFrom(message);
      saveReportUseCase.saveReport(reportData);

    } catch (InvalidProtocolBufferException e) {
      throw new IllegalArgumentException("Byte message could not be parsed to ReportData");
    }
  }
}
