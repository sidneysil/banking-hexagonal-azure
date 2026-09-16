package com.sidney.banking.account.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAccountRepository
        extends JpaRepository<AccountEntity, UUID> {

}
