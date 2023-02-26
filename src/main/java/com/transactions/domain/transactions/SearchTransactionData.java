package com.transactions.domain.transactions;

import java.util.List;

import org.springframework.data.domain.Sort;

public interface SearchTransactionData {

  List<Transaction> getAllTransactions(Sort sort);

  List<Transaction> searchTransactions(String accountIban, Sort sort);
}
