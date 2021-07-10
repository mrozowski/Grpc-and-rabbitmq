package com.mrozowski.reporter.report;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report/v1")
@RequiredArgsConstructor
class ReportController {

  private final GetReportUseCase getReportUseCase;

  @GetMapping
  ReportInformation getReport(){
    return getReportUseCase.getReportInformation();
  }
}
