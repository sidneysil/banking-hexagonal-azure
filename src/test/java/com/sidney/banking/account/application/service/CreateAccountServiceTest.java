package com.sidney.banking.account.application.service;

import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import com.sidney.banking.account.domain.Account;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import com.sidney.banking.account.application.port.out.AccountRepositoryPort;

public class CreateAccountServiceTest {
	
	 @Test
	    void shouldCreateAccount() {
		 
		 AccountRepositoryPort repository =
			        mock(AccountRepositoryPort.class);
		 
		 CreateAccountService service =
			        new CreateAccountService(repository);
		 
		 when(repository.save(any(Account.class)))
	        .thenAnswer(invocation -> invocation.getArgument(0));
		 
		 UUID customerId = UUID.randomUUID();

		 Account account = service.create(customerId);
		 
		 assertThat(account.getId()).isNotNull();
		 assertThat(account.getCustomerId()).isEqualTo(customerId);
		 assertThat(account.getBalance()).isEqualByComparingTo(BigDecimal.ZERO);
		 
		 verify(repository).save(any(Account.class));

	    }

}
