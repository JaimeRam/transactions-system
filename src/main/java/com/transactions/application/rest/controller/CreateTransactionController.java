package com.transactions.application.rest.controller;

import java.net.URI;

import com.transactions.application.rest.api.CreateTransactionRequest;
import com.transactions.application.rest.api.CreateTransactionResponse;
import com.transactions.application.rest.mapper.TransactionMapper;
import com.transactions.domain.transactions.CreateTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/create-transaction")
@AllArgsConstructor
public class CreateTransactionController {

  private final CreateTransactionService service;

  private final TransactionMapper mapper;

  @PostMapping
  public ResponseEntity<CreateTransactionResponse> createTransaction(
      @RequestBody CreateTransactionRequest transactionRequest) {
    service.createTransaction(mapper.mapRequestToTransaction(transactionRequest));
    return ResponseEntity.created(URI.create("")).build();
  }
}
