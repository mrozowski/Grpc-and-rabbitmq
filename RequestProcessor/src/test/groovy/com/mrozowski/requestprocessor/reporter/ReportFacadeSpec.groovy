package com.mrozowski.requestprocessor.reporter


import com.mrozowski.requestprocessor.utils.Decision
import com.mrozowski.study.grpc.api.v1.ReporterService.ReportData
import spock.lang.Specification

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ReportFacadeSpec extends Specification {

  def messageSender = Mock(ReportMessageSender)
  def underTest = new ReportFacade(messageSender)

  def "Should send report message"() {
    when:
    underTest.send(rawReportData)
    println rawReportData.requestDate
    then:
    1 * messageSender.send(*_) >> {arguments ->
      ReportData argument = arguments[0] as ReportData
      assert argument.requestName == rawReportData.name
      assert argument.requestDate.seconds == 1577872800
      assert argument.resultDate.seconds == 1620652805
      assert argument.decision.name() == rawReportData.decision.name()
    }
  }


  static rawReportData = RawReportData.builder()
      .name("someName")
      .decision(Decision.APPROVED)
      .requestDate(fromRawDate("2020-01-01 12:00:00"))
      .resultDate(fromRawDate("2021-05-10 15:20:05"))
      .build()

  static LocalDateTime fromRawDate(String date){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return LocalDateTime.parse(date, formatter)
  }
}
