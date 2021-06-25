package com.mrozowski.requestprocessor.processor;

import com.mrozowski.study.grpc.api.v1.BridgeServiceOuterClass.Request;

public interface Processor {
  void process(Request request);
}
