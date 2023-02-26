package com.transactions.application.rest.controller;

import com.transactions.application.rest.api.TransactionStatusRequest;
import com.transactions.application.rest.api.TransactionStatusResponse;
import com.transactions.application.rest.mapper.TransactionStatusMapper;
import com.transactions.domain.transactions.TransactionStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transaction-status")
@AllArgsConstructor
public class TransactionStatusController {

  private final TransactionStatusService service;

  private final TransactionStatusMapper mapper;

  @GetMapping
  public ResponseEntity<TransactionStatusResponse> transactionStatus(
      @RequestBody final TransactionStatusRequest request) {
    return ResponseEntity.ok().body(mapper.mapTransactionStatusToStatusResponse(
        service.getTransactionStatus(request.getReference(), request.getChannel())));
  }
}
