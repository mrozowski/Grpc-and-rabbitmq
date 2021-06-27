package com.mrozowski.bridge.request;

import lombok.RequiredArgsConstructor;

import com.mrozowski.bridge.datasource.RequestEntity;
import com.mrozowski.bridge.datasource.RequestStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/request/v1")
@RequiredArgsConstructor
class RequestController {

  private final SaveRequestUseCase saveRequestUseCase;
  private final GetRequestInfoUseCase getRequestInfoUseCase;

  @PostMapping
  ResponseEntity<UUID> sendRequest(@RequestBody UserRequest request){
    return ResponseEntity.ok(saveRequestUseCase.save(request));
  }

  @GetMapping("/{id}")
  Optional<RequestEntity> getRequest(@PathVariable("id") UUID id){
    return getRequestInfoUseCase.getRequest(id);
  }

  @GetMapping("/status/{id}")
  ResponseEntity<RequestStatus> getStatus(@PathVariable("id") UUID id){
    return ResponseEntity.ok(getRequestInfoUseCase.getStatus(id));
  }
}
