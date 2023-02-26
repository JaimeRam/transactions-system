package com.transactions.application.rest.mapper;

import com.transactions.application.jpa.transactions.JPATransaction;
import com.transactions.application.rest.api.CreateTransactionRequest;
import com.transactions.domain.transactions.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

  Transaction mapRequestToTransaction(CreateTransactionRequest transactionRequest);

  Transaction map(JPATransaction jpaTransaction);

  JPATransaction map(Transaction transaction);

}
