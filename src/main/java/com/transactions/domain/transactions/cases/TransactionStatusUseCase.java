package com.transactions.domain.transactions.cases;

import com.transactions.domain.transactions.ChannelEnum;
import com.transactions.domain.transactions.Transaction;
import com.transactions.domain.transactions.TransactionStatus;
import com.transactions.domain.transactions.TransactionStatusData;
import com.transactions.domain.transactions.TransactionStatusHandler;
import com.transactions.domain.transactions.TransactionStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.transactions.domain.transactions.TransactionStatusHandler.getInvalidTransactionStatus;
import static com.transactions.domain.transactions.TransactionStatusHandler.initializeDecider;

@Component
@AllArgsConstructor
@Transactional(readOnly = true)
public class TransactionStatusUseCase implements TransactionStatusService {

  private final TransactionStatusData transactionStatusData;

  @Override
  public TransactionStatus getTransactionStatus(final String reference, final ChannelEnum channel) {
    final Transaction transaction = transactionStatusData.transactionStatus(reference);

    if (transaction == null) {
      return getInvalidTransactionStatus(reference);
    }

    final TransactionStatusHandler transactionStatusHandler = initializeDecider(channel, reference,
        transaction);
    return transactionStatusHandler.manageTransactionStatus();
  }

}
