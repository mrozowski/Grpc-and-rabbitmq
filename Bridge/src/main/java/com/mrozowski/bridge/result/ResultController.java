package com.mrozowski.bridge.result;

import lombok.RequiredArgsConstructor;

import com.mrozowski.bridge.grpc.ServiceNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

  @ExceptionHandler({ RequestNotProcessedException.class })
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResponse> handleRequestNotProcessedException(RuntimeException exception) {
    return getErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({ ResultNotFoundException.class })
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorResponse> handleResultNotFoundException(RuntimeException exception) {
    return getErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({ ServiceNotAvailableException.class })
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ResponseEntity<ErrorResponse> handleServiceNotAvailableException(RuntimeException exception) {
    return getErrorResponse(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
  }

  private ResponseEntity<ErrorResponse> getErrorResponse(String message, HttpStatus httpStatus) {
    return new ResponseEntity<>(
        ErrorResponse
            .builder()
            .error(httpStatus.getReasonPhrase())
            .message(message)
            .status(httpStatus.value())
            .timestamp(LocalDateTime.now())
            .build(),
        httpStatus);
  }

}
