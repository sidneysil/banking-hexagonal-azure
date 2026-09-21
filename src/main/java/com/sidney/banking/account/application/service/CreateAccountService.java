package com.sidney.banking.account.application.service;

import java.math.BigDecimal;
import java.util.UUID;

import com.sidney.banking.account.application.port.in.CreateAccountUseCase;
import com.sidney.banking.account.application.port.out.AccountEventPublisherPort;
import com.sidney.banking.account.application.port.out.AccountRepositoryPort;
import com.sidney.banking.account.domain.Account;

public class CreateAccountService implements CreateAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;
    private final AccountEventPublisherPort accountEventPublisherPort;

    public CreateAccountService(
            AccountRepositoryPort accountRepositoryPort,
            AccountEventPublisherPort accountEventPublisherPort) {

        this.accountRepositoryPort = accountRepositoryPort;
        this.accountEventPublisherPort = accountEventPublisherPort;
    }

    @Override
    public Account create(UUID customerId) {

        Account account = new Account(
                UUID.randomUUID(),
                customerId,
                BigDecimal.ZERO
        );

        Account savedAccount = accountRepositoryPort.save(account);

        accountEventPublisherPort.publishAccountCreated(savedAccount);

        return savedAccount;
    }
}