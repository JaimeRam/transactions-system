package com.transactions.application.jpa.accounts;

import java.util.Optional;

import com.transactions.application.rest.mapper.AccountMapper;
import com.transactions.domain.accounts.Account;
import com.transactions.domain.accounts.GetAccountData;
import com.transactions.domain.accounts.UpdateAccountData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
@Transactional(readOnly = true)
public class JPAUpdateAccountData implements UpdateAccountData, GetAccountData {

  private final JPAAccountRepository repository;

  private final AccountMapper mapper;


  @Override
  public Optional<Account> getAccount(final String iban) {
    return Optional.of(mapper.mapJPAAccountToAccount(repository.findByIban(iban)));
  }

  @Override
  public void updateAccount(final Account account) {
    repository.updateBalanceByIban(account.getBalance(), account.getIban());
  }
}
