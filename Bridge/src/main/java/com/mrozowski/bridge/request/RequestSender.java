package com.mrozowski.bridge.request;

import com.mrozowski.bridge.datasource.RequestEntity;

public interface RequestSender {

  void send(RequestEntity requestEntity);
}
