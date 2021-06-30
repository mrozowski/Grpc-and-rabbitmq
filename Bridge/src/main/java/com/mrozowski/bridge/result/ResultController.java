package com.mrozowski.bridge.result;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("result/v1")
@RequiredArgsConstructor
class ResultController {

  private final GetResultUseCase getResultUseCase;

  @GetMapping("/{id}")
  ResponseEntity<ResultDto> getResult(@PathVariable("id") UUID id){
    return ResponseEntity.ok(getResultUseCase.getResult(id));
  }
}
