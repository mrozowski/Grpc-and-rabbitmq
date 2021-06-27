package com.mrozowski.bridge.request.event;

import lombok.Value;

import java.util.UUID;

@Value
public class RequestSavedEvent {

  UUID id;
}
