package com.mrozowski.reporter.report;

import lombok.Value;

@Value
public class Topic implements Comparable<Topic> {

  String topic;
  long value;

  @Override
  public int compareTo(Topic topic) {
    return Long.compare(topic.value, value);
  }
}