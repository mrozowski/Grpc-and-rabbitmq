package com.mrozowski.bridge.datasource

import spock.lang.Specification

import java.time.LocalDateTime

class RequestDatasourceSpec extends Specification {

  static UUID REQUEST_ID = UUID.fromString("21f8788c-78e1-4bc3-b651-a9ad0853ada1")
  def underTest = new RequestDatasource();

  def "should add request"(){
    when:
    underTest.add(REQUEST_1)

    then:
    getResources().first() == REQUEST_1
  }

  def "should change status"(){
    given:
    addResource(REQUEST_1)

    when:
    underTest.updateStatus(REQUEST_ID, RequestStatus.DONE)

    then:
    underTest.getStatus(REQUEST_ID) == RequestStatus.DONE
  }

  def "should find by id"(){
    given:
    addResource(REQUEST_1)

    when:
    def result = underTest.findById(REQUEST_ID)

    then:
    result.get() == REQUEST_1
  }


  def addResource(RequestEntity requestEntity){
    underTest.REQUEST_DATA.add(requestEntity)
  }

  def getResources(){
    return underTest.REQUEST_DATA
  }
  static REQUEST_1 = RequestEntity.builder()
      .id(REQUEST_ID)
      .request("someRequest")
      .name("someName")
      .date(LocalDateTime.MIN)
      .status(RequestStatus.PENDING)
      .build()
}
