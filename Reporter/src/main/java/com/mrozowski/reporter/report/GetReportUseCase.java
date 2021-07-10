package com.mrozowski.reporter.report;

import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@RequiredArgsConstructor
public class GetReportUseCase {

  private final ReportRepository repository;

  public ReportInformation getReportInformation() {
    var reports = repository.findAll();
    var processTime = getProcessTime(reports);
    var size = reports.size();
    var avgProcessTime = avg(processTime);
    var minProcessTime = min(processTime);
    var maxProcessTime = max(processTime);
    var topics = getPopularToRequestTopic(reports, 5);

    return ReportInformation.builder()
        .avgProcessTime(avgProcessTime)
        .maxProcessTime(maxProcessTime)
        .minProcessTime(minProcessTime)
        .mostPopularRequests(topics)
        .reportsNumber(size)
        .reports(reports)
        .build();
  }

  private static double avg(Collection<Long> collection) {
    return collection.stream()
        .mapToDouble(Long::doubleValue)
        .average().orElse(Double.NaN);
  }

  private static double min(Collection<Long> collection) {
    return collection.stream()
        .mapToDouble(Long::doubleValue)
        .min().orElse(Double.NaN);
  }

  private static double max(Collection<Long> collection) {
    return collection.stream()
        .mapToDouble(Long::doubleValue)
        .max().orElse(Double.NaN);
  }

  private static Collection<Long> getProcessTime(List<ReportEntity> reports) {
    return reports.stream().map(e -> Duration.between(e.getRequestDate(), e.getResultDate()))
        .map(Duration::getSeconds)
        .collect(Collectors.toList());
  }

  private static List<Topic> getPopularToRequestTopic(List<ReportEntity> reports, int limit) {
    var topics = reports
        .stream()
        .collect(Collectors.groupingBy(ReportEntity::getRequestName, Collectors.counting()))
        .entrySet()
        .stream()
        .map(e -> new Topic(e.getKey(), e.getValue()))
        .sorted().collect(Collectors.toList());

    return topics.stream().limit(limit).collect(Collectors.toList());
  }
}
