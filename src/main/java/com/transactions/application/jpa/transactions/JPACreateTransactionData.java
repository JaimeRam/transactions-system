package com.transactions.application.jpa.transactions;

import com.transactions.application.rest.mapper.TransactionMapper;
import com.transactions.domain.transactions.CreateTransactionData;
import com.transactions.domain.transactions.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
@Transactional(readOnly = true)
public class JPACreateTransactionData implements CreateTransactionData {

  private final JPATransactionRepository repository;
  private final TransactionMapper mapper;

  @Override
  public void createTransaction(final Transaction transaction) {
    repository.save(mapper.map(transaction));
  }
}
