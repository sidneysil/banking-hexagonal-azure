package com.sidney.banking.account.application.port.out;

import com.sidney.banking.account.domain.Account;

public interface AccountRepositoryPort {
	
	Account save(Account account);

}
