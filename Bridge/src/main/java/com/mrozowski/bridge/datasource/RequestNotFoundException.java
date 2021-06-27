package com.mrozowski.bridge.datasource;

class RequestNotFoundException extends RuntimeException {

  public RequestNotFoundException() {
    super("Request not found");
  }
}
