package com.transactions.domain.accounts.cases;

import java.util.Optional;

import com.transactions.domain.accounts.Account;
import com.transactions.domain.accounts.GetAccountData;
import com.transactions.domain.accounts.UpdateAccountData;
import com.transactions.domain.accounts.UpdateAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
@Transactional(readOnly = true)
public class UpdateAccountCase implements UpdateAccountService {

  private final UpdateAccountData updateAccountData;

  private final GetAccountData getAccountData;

  @Override
  public void updateAccount(final String iban, final Double amount) {
    final Optional<Account> accountToUpdate = getAccountData.getAccount(iban);
    if (accountToUpdate.isPresent() && accountToUpdate.get().getBalance() >= amount) {
      final Account updatedAccount = accountToUpdate.get();
      updatedAccount.setBalance(accountToUpdate.get().getBalance() + amount);
      updateAccountData.updateAccount(updatedAccount);
    }
  }
}
