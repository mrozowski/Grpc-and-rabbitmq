package com.mrozowski.bridge.request

import com.mrozowski.bridge.datasource.RequestEntity
import com.mrozowski.bridge.datasource.RequestRepository
import com.mrozowski.bridge.datasource.RequestStatus
import spock.lang.Specification

class SaveRequestUseCaseSpec extends Specification {

  def repository = Mock(RequestRepository)
  def underTest = new SaveRequestUseCase(repository)

  def "should return id of a new request"(){
    when:
    def result = underTest.save(USER_REQUEST)

    then:
    result.toString().length() == 36
  }

  def "should save a new request"(){
    when:
    underTest.save(USER_REQUEST)

    then:
    1 * repository.add(*_) >> {arguments ->
      RequestEntity argument = arguments[0] as RequestEntity
      assert argument.name == USER_REQUEST.name
      assert argument.request == USER_REQUEST.request
      assert argument.status == RequestStatus.PENDING
    }
  }

  static UserRequest USER_REQUEST = new UserRequest("someName", "someRequest")
}
