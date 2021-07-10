package com.mrozowski.bridge.result;

class RequestNotProcessedException extends RuntimeException{

  public RequestNotProcessedException(String message) {
    super(message);
  }
}
