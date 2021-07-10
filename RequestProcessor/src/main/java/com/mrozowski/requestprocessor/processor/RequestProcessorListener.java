package com.mrozowski.requestprocessor.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.mrozowski.requestprocessor.datasource.ResultEntity;
import com.mrozowski.requestprocessor.datasource.ResultRepository;
import com.mrozowski.requestprocessor.processor.event.RequestProcessedEvent;
import com.mrozowski.requestprocessor.reporter.RawReportData;
import com.mrozowski.requestprocessor.reporter.ReportFacade;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
@Slf4j
class RequestProcessorListener {

  private final RequestProcessNotifier notifier;
  private final ResultRepository resultRepository;
  private final ReportFacade reportFacade;

  @EventListener
  public void onRequestProcessCompleted(RequestProcessedEvent event){
    notifier.notifyProcessCompleted(event.getRequestId());
    log.info("Bridge notified about completed process");

    var resultEntity = resultRepository.findByRequestId(event.getRequestId());
    var reportData = createReportData(resultEntity.orElseThrow(), event);
    // TODO: send message on queue for reporter service

    reportFacade.send(reportData);
    log.info("Message was sent to Reporter service");
  }

  private RawReportData createReportData(ResultEntity resultEntity, RequestProcessedEvent event) {
    return RawReportData.builder()
        .decision(resultEntity.getDecision())
        .resultDate(resultEntity.getDate())
        .requestDate(event.getRequestDate())
        .name(event.getName())
        .build();
  }
}
