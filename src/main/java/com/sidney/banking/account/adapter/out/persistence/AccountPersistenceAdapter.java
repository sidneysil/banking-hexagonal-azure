package com.sidney.banking.account.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.sidney.banking.account.application.port.out.AccountRepositoryPort;
import com.sidney.banking.account.domain.Account;

@Repository
public class AccountPersistenceAdapter implements AccountRepositoryPort {

    private final SpringDataAccountRepository repository;

    public AccountPersistenceAdapter(
            SpringDataAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {

        AccountEntity entity = new AccountEntity(
                account.getId(),
                account.getCustomerId(),
                account.getBalance()
        );

        AccountEntity savedEntity = repository.save(entity);

        return new Account(
                savedEntity.getId(),
                savedEntity.getCustomerId(),
                savedEntity.getBalance()
        );
    } 
}