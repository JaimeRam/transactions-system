package com.transactions.domain.accounts;

import java.util.Optional;

public interface GetAccountData {

  Optional<Account> getAccount(String iban);
}
