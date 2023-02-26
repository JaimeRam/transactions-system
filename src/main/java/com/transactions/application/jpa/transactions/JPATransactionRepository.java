package com.transactions.application.jpa.transactions;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface JPATransactionRepository extends CrudRepository<JPATransaction, Integer> {

  List<JPATransaction> findAll();

  List<JPATransaction> findAll(Sort sort);

  List<JPATransaction> findByAccountIban(String accountIban, Sort sort);

  JPATransaction findByReference(String reference);

}