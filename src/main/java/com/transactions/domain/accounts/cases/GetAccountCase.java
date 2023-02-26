package com.transactions.domain.accounts.cases;

import java.util.Optional;

import com.transactions.domain.accounts.Account;
import com.transactions.domain.accounts.GetAccountData;
import com.transactions.domain.accounts.GetAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
@Transactional(readOnly = true)
public class GetAccountCase implements GetAccountService {

  private final GetAccountData getAccountData;

  @Override
  public Optional<Account> getAccountByIban(final String iban) {
    return getAccountData.getAccount(iban);
  }
}
