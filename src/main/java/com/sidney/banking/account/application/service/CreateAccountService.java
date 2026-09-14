package com.sidney.banking.account.application.service;

import java.math.BigDecimal;
import java.util.UUID;

import com.sidney.banking.account.application.port.in.CreateAccountUseCase;
import com.sidney.banking.account.application.port.out.AccountRepositoryPort;
import com.sidney.banking.account.domain.Account;

public class CreateAccountService implements CreateAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;

    public CreateAccountService(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Account create(UUID customerId) {

        Account account = new Account(
                UUID.randomUUID(),
                customerId,
                BigDecimal.ZERO
        );

        return accountRepositoryPort.save(account);
    }
}