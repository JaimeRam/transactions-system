package com.transactions.application.rest.mapper;

import com.transactions.application.rest.api.TransactionStatusResponse;
import com.transactions.domain.transactions.TransactionStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionStatusMapper {

  TransactionStatusResponse mapTransactionStatusToStatusResponse(TransactionStatus transaction);

}
