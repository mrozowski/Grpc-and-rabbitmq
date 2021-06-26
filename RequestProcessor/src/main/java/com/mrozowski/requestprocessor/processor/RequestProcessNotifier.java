package com.mrozowski.requestprocessor.processor;

import java.util.UUID;

public interface RequestProcessNotifier {

  void notifyProcessCompleted(UUID requestId);
}
