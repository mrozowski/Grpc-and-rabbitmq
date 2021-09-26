package com.mrozowski.requestprocessor.utils

import com.google.protobuf.Timestamp
import spock.lang.Specification

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class DateHelperSpec extends Specification {

  def "should parse timestamp to data"() {
    given:
    var timestamp = getTimeStamp(getTestDate())

    when:
    def date = DateHelper.toDate(timestamp)

    then:
    date == getTestDate()
  }

  def "should parse localDateTime to string"() {
    given:
    var localDateTime = getTestDate()

    when:
    def result = DateHelper.toStringData(localDateTime)

    then:
    result == "05-10-2021 20:15:10.123"
  }

  def "should parse date to timestamp"() {
    given:
    var date = getTestDate()

    when:
    def timestamp = DateHelper.getTimestamp(date)

    then:
    timestamp.seconds == 1633457710
  }

  static Timestamp getTimeStamp(LocalDateTime date) {
    return Timestamp.newBuilder()
        .setSeconds(date.toEpochSecond(OffsetDateTime.now().getOffset()))
        .setNanos(date.nano)
        .build()
  }

  static LocalDateTime getTestDate() {
    var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")
    return LocalDateTime.parse("05-10-2021 20:15:10.123", formatter)
  }
}
