package com.mrozowski.bridge.result;

class ResultNotFoundException extends RuntimeException {

  ResultNotFoundException(String message) {
    super(message);
  }
}
