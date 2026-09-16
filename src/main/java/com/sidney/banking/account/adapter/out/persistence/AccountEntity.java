package com.sidney.banking.account.adapter.out.persistence;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountEntity {

	@Id
	@Column(name = "id", nullable = false)
	private UUID id;

	@Column(name = "customer_id", nullable = false)
	private UUID customerId;

	@Column(name = "balance", nullable = false, precision = 19, scale = 2)
	private BigDecimal balance;

    protected AccountEntity() {
    }

    public AccountEntity(UUID id, UUID customerId, BigDecimal balance) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
