package com.transactions.application.rest.mapper;

import com.transactions.application.jpa.accounts.JPAAccount;
import com.transactions.domain.accounts.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  Account mapJPAAccountToAccount(JPAAccount jpaAccount);
}
