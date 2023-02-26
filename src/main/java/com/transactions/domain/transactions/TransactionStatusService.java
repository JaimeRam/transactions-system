package com.transactions.domain.transactions;

public interface TransactionStatusService {

  TransactionStatus getTransactionStatus(String reference, ChannelEnum channel);
}
