package com.transactions.application.rest.api;

import javax.validation.constraints.NotNull;

import com.transactions.domain.transactions.ChannelEnum;
import lombok.Value;

@Value
public class TransactionStatusRequest {

  @NotNull String reference;
  ChannelEnum channel;
}
