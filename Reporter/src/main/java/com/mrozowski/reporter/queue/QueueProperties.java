package com.mrozowski.reporter.queue;

import lombok.Value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@ConstructorBinding
@ConfigurationProperties("reporter.messaging.result")
class QueueProperties {

  String queue;
  String exchange;
  String routingKey;
}
