package com.transactions.domain.transactions;

import java.time.LocalDateTime;


public class TransactionStatusFromAtm extends TransactionStatusHandler {

  public TransactionStatusFromAtm(final String reference, final Transaction transaction) {
    this.reference = reference;
    this.transaction = transaction;
  }

  @Override
  public TransactionStatus manageTransactionStatus() {

    if (transaction.getDate().isBefore(LocalDateTime.now().toLocalDate().atStartOfDay())) {
      return TransactionStatus.builder()
          .reference(reference)
          .status(TransactionStatusEnum.SETTLED)
          .amount(transaction.getAmount() - transaction.getFee())
          .build();
    }

    if (datesOnTheSameDay(transaction.getDate(), LocalDateTime.now())) {
      return TransactionStatus.builder()
          .reference(reference)
          .status(TransactionStatusEnum.PENDING)
          .amount(transaction.getAmount() - transaction.getFee())
          .build();
    }

    if (transaction.getDate().isAfter(LocalDateTime.now().toLocalDate().atStartOfDay())) {
      return TransactionStatus.builder()
          .reference(reference)
          .status(TransactionStatusEnum.PENDING)
          .amount(transaction.getAmount() - transaction.getFee())
          .build();
    }

    return getInvalidTransactionStatus(reference);
  }
}
