package com.transactions.application.rest.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Value;

@Value
@JsonInclude(Include.NON_NULL)
public class TransactionStatusResponse {

  @NotNull String reference;
  @NotNull String status;
  Double amount;
  Double fee;
}
