package com.mrozowski.reporter.report;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@Entity
@Table(name = "report")
@NoArgsConstructor
public class ReportEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String requestName;
  @Enumerated(EnumType.STRING)
  private Decision decision;
  private LocalDateTime requestDate;
  private LocalDateTime resultDate;

  @Builder
  ReportEntity(String requestName, Decision decision, LocalDateTime requestDate, LocalDateTime resultDate) {
    this.requestName = requestName;
    this.decision = decision;
    this.requestDate = requestDate;
    this.resultDate = resultDate;
  }

}
