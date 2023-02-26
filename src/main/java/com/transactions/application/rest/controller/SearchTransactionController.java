package com.transactions.application.rest.controller;

import java.util.List;

import com.transactions.domain.transactions.SearchTransactionService;
import com.transactions.domain.transactions.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search-transaction")
@AllArgsConstructor
public class SearchTransactionController {

  public static final String SORT_FIELD = "amount";
  private final SearchTransactionService service;

  @GetMapping(value = "/{account-iban}")
  public ResponseEntity<List<Transaction>> searchTransactions(
      @PathVariable(name = "account-iban") final String accountIban,
      @RequestParam(defaultValue = "sort") final String sort) {
    return ResponseEntity.ok().body(service.searchTransaction(accountIban, getSortDirection(sort)));
  }

  private Sort getSortDirection(String direction) {
    if (direction.equals("asc")) {
      return Sort.by(SORT_FIELD).ascending();
    } else if (direction.equals("desc")) {
      return Sort.by(SORT_FIELD).descending();
    }
    return Sort.by(SORT_FIELD).ascending();
  }
}
