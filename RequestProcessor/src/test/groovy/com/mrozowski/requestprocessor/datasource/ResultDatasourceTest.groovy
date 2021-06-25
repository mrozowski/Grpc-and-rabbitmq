package com.mrozowski.requestprocessor.datasource

import spock.lang.Specification

class ResultDatasourceTest extends Specification {

  def underTest = new ResultDatasource()

  def "Should add and find a new result entity"(){
    when:
    underTest.add(RESULT_1)

    then:
    def object = underTest.findByRequestId(UUID.fromString("31f8788c-78e1-4bc3-b651-a9ad0853ada8"))
    object.get() == RESULT_1
  }

  static RESULT_1 = ResultEntity.builder()
      .id(UUID.fromString("21f8788c-78e1-4bc3-b651-a9ad0853ada1"))
      .requestId(UUID.fromString("31f8788c-78e1-4bc3-b651-a9ad0853ada8"))
      .result("someResult")
      .date(new Date())
      .build()
}
