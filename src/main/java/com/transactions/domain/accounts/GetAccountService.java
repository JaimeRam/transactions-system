package com.transactions.domain.accounts;

import java.util.Optional;

public interface GetAccountService {

  Optional<Account> getAccountByIban(String iban);
}
