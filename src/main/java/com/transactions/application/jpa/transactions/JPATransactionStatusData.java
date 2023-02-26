package com.transactions.application.jpa.transactions;

import com.transactions.application.rest.mapper.TransactionMapper;
import com.transactions.domain.transactions.Transaction;
import com.transactions.domain.transactions.TransactionStatusData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
@Transactional(readOnly = true)
public class JPATransactionStatusData implements TransactionStatusData {

  private final JPATransactionRepository repository;
  private final TransactionMapper mapper;

  @Override
  public Transaction transactionStatus(String reference) {
    return mapper.map(repository.findByReference(reference));
  }
}
