package com.transactions.domain.transactions.cases;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.transactions.domain.accounts.Account;
import com.transactions.domain.accounts.TransactionException;
import com.transactions.domain.accounts.cases.GetAccountCase;
import com.transactions.domain.transactions.CreateTransactionData;
import com.transactions.domain.transactions.CreateTransactionService;
import com.transactions.domain.transactions.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
@AllArgsConstructor
@Transactional(readOnly = true)
public class CreateTransactionUseCase implements CreateTransactionService {

  private final CreateTransactionData createTransactionData;

  private final GetAccountCase getAccountCase;

  @Override
  public void createTransaction(final Transaction transaction) {
    checkTransactionConditions(transaction);
    createTransactionData.createTransaction(transaction);
  }


  private void checkTransactionConditions(final Transaction transaction) {
    final Optional<Account> relatedAccount = getAccountCase.getAccountByIban(
        transaction.getAccountIban());
    if (relatedAccount.isEmpty() || relatedAccount.get().getBalance() < transaction.getAmount()) {
      throw new TransactionException("Failed to create transaction: " + transaction.getReference());
    }
    if (!StringUtils.hasText(transaction.getReference())) {
      transaction.setReference(UUID.randomUUID().toString());
    }
    if (transaction.getDate() == null) {
      transaction.setDate(LocalDateTime.now());
    }
  }
}
