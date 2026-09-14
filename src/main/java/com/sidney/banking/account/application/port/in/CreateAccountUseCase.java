package com.sidney.banking.account.application.port.in;

import java.util.UUID;

import com.sidney.banking.account.domain.Account;


public interface CreateAccountUseCase {
	
    Account create(UUID customerId);

}
