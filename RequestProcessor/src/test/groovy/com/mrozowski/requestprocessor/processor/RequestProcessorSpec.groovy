package com.mrozowski.requestprocessor.processor

import com.mrozowski.requestprocessor.datasource.ResultEntity
import com.mrozowski.requestprocessor.datasource.ResultRepository
import org.springframework.context.ApplicationEventPublisher
import spock.lang.Specification

import java.time.LocalDateTime

class RequestProcessorSpec extends Specification {

  static UUID REQUEST_ID = UUID.fromString("21f8788c-78e1-4bc3-b651-a9ad0853ada1")

  def repository = Mock(ResultRepository)
  def eventPublisher = Mock(ApplicationEventPublisher)
  def underTest = new RequestProcessor(repository, eventPublisher)

  def "should create and add result"(){
    when:
    underTest.process(REQUEST_1)

    then:
    1 * repository.add(*_) >> {arguments ->
      ResultEntity argument = arguments[0] as ResultEntity
      assert argument.getRequestId() == REQUEST_1.getId()
      assert !argument.getResult().isBlank()
    }
  }

  static RequestData REQUEST_1 = RequestData.builder()
      .id(REQUEST_ID)
      .name("someName")
      .request("someRequest")
      .date(getTestDate())
      .build()

  static LocalDateTime getTestDate(){
    return LocalDateTime.of(2020, 5, 10, 20, 15, 10)
  }
}
