package com.transactions.domain.transactions.cases;

import java.util.List;

import com.transactions.domain.transactions.SearchTransactionData;
import com.transactions.domain.transactions.SearchTransactionService;
import com.transactions.domain.transactions.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
@AllArgsConstructor
@Transactional(readOnly = true)
public class SearchTransactionUseCase implements SearchTransactionService {

  private final SearchTransactionData searchTransactionData;

  @Override
  public List<Transaction> searchTransaction(String accountIban, Sort sort) {
    if (StringUtils.hasText(accountIban)) {
      return searchTransactionData.searchTransactions(accountIban, sort);
    }
    return searchTransactionData.getAllTransactions(sort);
  }
}
