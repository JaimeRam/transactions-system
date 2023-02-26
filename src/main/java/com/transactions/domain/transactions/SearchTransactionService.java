package com.transactions.domain.transactions;

import java.util.List;

import org.springframework.data.domain.Sort;

public interface SearchTransactionService {

  List<Transaction> searchTransaction(String accountIban, Sort sort);
}
