package com.transactions.application.rest.api;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateTransactionRequest {

  String reference;
  @NotNull String accountIban;
  String date;
  @NotNull Double amount;
  Double fee;
  String description;
}
