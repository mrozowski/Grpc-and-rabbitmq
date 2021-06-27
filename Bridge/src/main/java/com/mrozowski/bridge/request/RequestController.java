package com.mrozowski.bridge.request;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/request/v1")
@RequiredArgsConstructor
class RequestController {

  private final SaveRequestUseCase saveRequestUseCase;

  @PostMapping
  ResponseEntity<UUID> sendRequest(@RequestBody UserRequest request){
    return ResponseEntity.ok(saveRequestUseCase.save(request));
  }
}
