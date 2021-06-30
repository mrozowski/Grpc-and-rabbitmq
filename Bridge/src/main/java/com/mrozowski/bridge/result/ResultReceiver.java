package com.mrozowski.bridge.result;

import java.util.UUID;

public interface ResultReceiver {

  ResultDto receive(UUID id);
}
