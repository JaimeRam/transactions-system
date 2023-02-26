package com.transactions.domain.transactions;

import java.time.LocalDateTime;


public abstract class TransactionStatusHandler {

  protected String reference;

  protected String status;

  protected Transaction transaction;

  public static TransactionStatusHandler initializeDecider(final ChannelEnum channel,
      final String reference, final Transaction transaction) {
    return switch (channel) {
      case CLIENT -> new TransactionStatusFromClient(reference, transaction);
      case ATM -> new TransactionStatusFromAtm(reference, transaction);
      case INTERNAL -> new TransactionStatusFromInternal(reference, transaction);
    };
  }

  public abstract TransactionStatus manageTransactionStatus();

  public static TransactionStatus getInvalidTransactionStatus(final String reference) {
    return TransactionStatus.builder().reference(reference).status(TransactionStatusEnum.INVALID)
        .build();
  }


  public static boolean datesOnTheSameDay(final LocalDateTime a, final LocalDateTime b) {
    return a.toLocalDate().equals(b.toLocalDate());
  }
}
