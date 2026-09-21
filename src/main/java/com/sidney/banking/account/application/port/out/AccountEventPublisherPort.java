package com.sidney.banking.account.application.port.out;

import com.sidney.banking.account.domain.Account;

public interface AccountEventPublisherPort {
	
	void publishAccountCreated(Account account);

}
