package com.mrozowski.requestprocessor.processor;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import com.mrozowski.requestprocessor.datasource.ResultEntity;
import com.mrozowski.requestprocessor.datasource.ResultRepository;
import com.mrozowski.requestprocessor.processor.event.RequestProcessedEvent;
import com.mrozowski.requestprocessor.utils.Decision;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.mrozowski.requestprocessor.utils.DateHelper.toStringData;

@RequiredArgsConstructor
class RequestProcessor implements Processor {

  private static final char NEW_LINE = '\n';
  private final ResultRepository resultRepository;
  private final ApplicationEventPublisher eventPublisher;

  @Async
  @Override
  @SneakyThrows
  public void process(RequestData request) {
    TimeUnit.SECONDS.sleep(1);  //Add some delay to simulate long processing

    var decision = makeDecision();
    var responseMessage = createResponseMessage(request, decision);

    var resultData = createResult(responseMessage.toString(), request.getId(), decision);
    resultRepository.add(resultData);

    eventPublisher.publishEvent(createEvent(request));
  }

  private static RequestProcessedEvent createEvent(RequestData request) {
    return RequestProcessedEvent.builder()
        .requestId(request.getId())
        .name(request.getName())
        .requestDate(request.getDate())
        .build();
  }

  private static Decision makeDecision() {
    var rand = new Random();
    var decision = rand.nextBoolean();
    return decision? Decision.APPROVED : Decision.DENIED;
  }

  private static StringBuilder createResponseMessage(RequestData request, Decision decision) {
    return new StringBuilder()
        .append(String.format("Request '%s'", request.getName()))
        .append(NEW_LINE)
        .append(request.getRequest())
        .append(NEW_LINE)
        .append(String.format("from %s,", toStringData(request.getDate())))
        .append(NEW_LINE)
        .append("was ")
        .append(decision.toString());
  }

  private static ResultEntity createResult(String message, UUID requestId, Decision decision) {
    return ResultEntity.builder()
        .id(UUID.randomUUID())
        .requestId(requestId)
        .result(message)
        .decision(decision)
        .date(LocalDateTime.now())
        .build();
  }
}
