package com.transactions.application.jpa.transactions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class JPATransaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "reference", nullable = false, unique = true)
  private String reference;
  @Column(name = "account_iban", nullable = false)
  private String accountIban;
  @Column(name = "date", nullable = false)
  private LocalDateTime date;
  @Column(name = "amount", nullable = false)
  private Double amount;
  @Column(name = "fee")
  private Double fee;
  @Column(name = "description")
  private String description;
}
