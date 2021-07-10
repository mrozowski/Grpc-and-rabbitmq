package com.mrozowski.requestprocessor.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.mrozowski.requestprocessor.reporter.ReportMessageSender;
import com.mrozowski.study.grpc.api.v1.ReporterService.ReportData;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@Slf4j
class AmqpReporterMessageSender implements ReportMessageSender {

  private final AmqpTemplate amqpTemplate;
  private final String exchange;
  private final String key;

  @Override
  public void send(ReportData reportData) {
    amqpTemplate.convertAndSend(
        exchange,
        key,
        reportData.toByteArray()
    );
    log.info("Report {} sent", reportData.getRequestName());
  }
}
