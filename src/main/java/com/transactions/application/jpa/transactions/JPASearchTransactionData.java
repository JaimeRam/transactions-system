package com.transactions.application.jpa.transactions;

import java.util.List;

import com.transactions.application.rest.mapper.TransactionMapper;
import com.transactions.domain.transactions.SearchTransactionData;
import com.transactions.domain.transactions.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
@Transactional(readOnly = true)
public class JPASearchTransactionData implements SearchTransactionData {

  private final JPATransactionRepository repository;
  private final TransactionMapper mapper;

  @Override
  public List<Transaction> getAllTransactions(final Sort sort) {
    return repository.findAll(sort)
        .stream()
        .map(mapper::map)
        .toList();
  }

  @Override
  public List<Transaction> searchTransactions(final String accountIban, final Sort sort) {
    return repository.findByAccountIban(accountIban, sort)
        .stream()
        .map(mapper::map)
        .toList();
  }
}
