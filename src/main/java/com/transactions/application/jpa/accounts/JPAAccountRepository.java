package com.transactions.application.jpa.accounts;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPAAccountRepository extends CrudRepository<JPAAccount, Integer> {

  JPAAccount findByIban(String iban);

  @Modifying
  @Query(value = "update accounts a set a.balance = :balance where a.iban = :iban", nativeQuery = true)
  void updateBalanceByIban(Double balance, String iban);

}