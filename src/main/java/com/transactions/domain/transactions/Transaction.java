package com.transactions.domain.transactions;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Transaction {

  private String reference;
  private String accountIban;
  private LocalDateTime date;
  private Double amount;
  private Double fee;
  private String description;
}
