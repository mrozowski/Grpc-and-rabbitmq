package com.mrozowski.bridge.grpc;

public class ServiceNotAvailableException extends RuntimeException{

  public ServiceNotAvailableException(String message) {
    super(message);
  }
}
